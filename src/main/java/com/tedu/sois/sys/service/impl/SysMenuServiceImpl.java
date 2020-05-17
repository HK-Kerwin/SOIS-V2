package com.tedu.sois.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tedu.sois.common.util.ShiroUtils;
import com.tedu.sois.sys.dao.SysUserRoleDao;
import com.tedu.sois.sys.vo.SysUserMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.dao.SysMenuDao;
import com.tedu.sois.sys.dao.SysRoleMenuDao;
import com.tedu.sois.sys.entity.SysMenu;
import com.tedu.sois.sys.service.SysMenuService;

/**
 * 此类中负责菜单业务的具体处理
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public void saveSysMenuInfo(SysMenu entity) {
        if (entity == null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getMenuName()))
            throw new IllegalArgumentException("菜单名不能为空");
        entity.setCreatedUser(ShiroUtils.getUsername());
        entity.setCreatedTime(new Date());
        int rows = sysMenuDao.insertSysMenuInfo(entity);
        if(rows == 0)
            throw new ServiceException("保存失败");
    }


    @Override
    public int deleteSysMenuInfoById(Integer menuId) {
        //1.参数有效性校验
        if (menuId == null || menuId < 1)
            throw new IllegalArgumentException("id值无效");
        //2.统计子菜单数据并校验
        int childCount = sysMenuDao.getChildCount(menuId);
        if (childCount > 0)
            throw new ServiceException("请先删除子菜单");
        //3.删除菜单角色关系数据
        sysRoleMenuDao.deleteSysRoleMenuByMenuId(menuId);
        //4.删除菜单自身信息并返回结果
        int rows = sysMenuDao.deleteSysMenuInfo(menuId);
        if (rows == 0)
            throw new ServiceException("记录可能已经不存在");
        return rows;
    }

    @Override
    public int modifySysMenuInfo(SysMenu entity) {
        if (entity == null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getMenuName()))
            throw new IllegalArgumentException("菜单名不能为空");
        if (entity.getParentId() == null || entity.getParentId() == 0)
            throw new ServiceException("顶级菜单不允许修改");
        entity.setModifiedTime(new Date());
        entity.setModifiedUser(ShiroUtils.getUsername());
        int rows = sysMenuDao.updateSysMenuInfo(entity);
        if (rows == 0)
            throw new ServiceException("修改菜单信息失败");
        return rows;
    }


    @Override
    public List<Map<String, Object>> findMenuList() {
        List<Map<String, Object>> list = sysMenuDao.selectMenuList();
        if (list == null || list.size() == 0)
            throw new ServiceException("没有找到对应记录");
        return list;
    }

    @Override
    public List<Node> findZtreeMenuNodes() {
        List<Node> nodes = sysMenuDao.selectZtreeMenuNodes();
        List<Node> result = treeSelect(nodes,0);
        return result;
    }

    /**
     * 递归求树
     * @param nodes 全部的节点信息
     * @param parentId 父节点id
     * @return
     */
    private List<Node> treeSelect(List<Node> nodes,Integer parentId) {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getParentId() == parentId || node.getParentId().equals(parentId)) {
                List<Node> childMenuList = treeSelect(nodes,node.getId());
                node.setChildren(childMenuList);
                result.add(node);
            }
        }
        return result;
    }


    @Override
    public List<SysUserMenuVo> findMenusByUserId(Long userId) {
        //获取角色id
        List<Integer> roleIds = sysUserRoleDao.selectRoleIdsByUserId(userId);
        //获取菜单id
        List<Integer> menuIds = sysRoleMenuDao.selectMenuIdsByRoleIds(roleIds);
        //获取菜单
        //List<SysUserMenuVo> sysUserMenuVos = sysMenuDao.selectMenusByIds(menuIds);//mybatis二级
        List<SysUserMenuVo> sysUserMenuVos = sysMenuDao.selectMenusListByIds(menuIds);//获取全部使用递归
        sysUserMenuVos = treeSelectByMenuVo(sysUserMenuVos,8);
        return treeSelectByMenuVoClear(sysUserMenuVos);
    }

    /**
     * 递归求树
     * @param nodes 全部的节点信息
     * @param parentId 父节点id
     * @return
     */
    private List<SysUserMenuVo> treeSelectByMenuVo(List<SysUserMenuVo> sysUserMenuVo,Integer parentId) {
        List<SysUserMenuVo> result = new ArrayList<>();
        for (SysUserMenuVo menuVo : sysUserMenuVo) {
            if (menuVo.getParentId() == parentId || menuVo.getParentId().equals(parentId)) {
                List<SysUserMenuVo> childMenuList = treeSelectByMenuVo(sysUserMenuVo,menuVo.getMenuId());
                menuVo.setChildren(childMenuList);
                result.add(menuVo);
            }
        }
        return result;
    }

    private List<SysUserMenuVo> treeSelectByMenuVoClear(List<SysUserMenuVo> sysUserMenuVo){
        for (SysUserMenuVo menuVo: sysUserMenuVo) {
            if (menuVo.getChildren().size() != 0){
                treeSelectByMenuVoClear(menuVo.getChildren());
            }
            if (menuVo.getChildren().size() == 0){
                menuVo.setChildren(null);
            }
        }
        return sysUserMenuVo;
    }
}
