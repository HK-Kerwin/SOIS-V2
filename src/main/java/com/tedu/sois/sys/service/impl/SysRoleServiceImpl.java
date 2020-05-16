package com.tedu.sois.sys.service.impl;

import java.util.Date;
import java.util.List;

import com.tedu.sois.common.util.ShiroUtils;
import com.tedu.sois.common.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tedu.sois.common.annotation.RequiredLog;
import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.common.vo.CheckBox;
import com.tedu.sois.common.vo.PageObject;
import com.tedu.sois.sys.dao.SysRoleDao;
import com.tedu.sois.sys.dao.SysRoleMenuDao;
import com.tedu.sois.sys.dao.SysUserRoleDao;
import com.tedu.sois.sys.entity.SysRole;
import com.tedu.sois.sys.service.SysRoleService;
import com.tedu.sois.sys.vo.SysRoleMenuVo;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    //@Autowired
    private SysRoleDao sysRoleDao;
    //@Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    //@Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    public SysRoleServiceImpl(SysRoleDao sysRoleDao, SysRoleMenuDao sysRoleMenuDao, SysUserRoleDao sysUserRoleDao) {
        super();
        this.sysRoleDao = sysRoleDao;
        this.sysRoleMenuDao = sysRoleMenuDao;
        this.sysUserRoleDao = sysUserRoleDao;
    }

    @Override
    public String findRoleNameByUserId(Long stuId) {
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(stuId);
		if (roleIds == null || roleIds.size() == 0)
            throw new ServiceException("没有找到角色编号");
        Integer roleId = roleIds.get(0);
        SysRoleMenuVo data = sysRoleDao.selectRoleAndMenuInfoById(roleId);
        if(data == null)
            throw new ServiceException("没有找到角色的信息");

        return data.getRoleName();
    }

    @RequiredLog
    @Cacheable("roleCache")
    @Override
    public List<CheckBox> findObjects() {
        return sysRoleDao.findObjects();
    }

    @Override
    public SysRoleMenuVo findRoleAndMenuInfoByRoleId(Integer roleId) {
        if (roleId == null || roleId < 1)
            throw new IllegalArgumentException("id值无效");
        SysRoleMenuVo rm = sysRoleDao.selectRoleAndMenuInfoById(roleId);
        if (rm == null)
            throw new ServiceException("记录可能已不存在");
        return rm;
    }

    @Override
    public int modifyRoleInfo(SysRole entity, Integer[] menuIds) {
        //1.参数有效性校验
        if (entity == null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getRoleName()))
            throw new IllegalArgumentException("角色名不允许为空");
        if (menuIds == null || menuIds.length == 0)
            throw new ServiceException("必须为角色分配权限");
        int row = sysRoleDao.getRoleInfoRowCount(entity.getRoleName());
        if (row > 0)
            throw new ServiceException("角色已经存在,请查询");
        entity.setModifiedUser(ShiroUtils.getUsername());
        entity.setModifiedTime(new Date());
        //2.保存角色自身信息
        int rows = sysRoleDao.updateRoleInfo(entity);
        //3.保存角色菜单关系数据
        //3.1)先删除原有关系数据
        sysRoleMenuDao.deleteSysRoleMenuByRoleId(entity.getRoleId());
        //3.2)添加新的关系数据
        sysRoleMenuDao.insertSysRoleMenu(entity.getRoleId(), menuIds);
        //4.返回业务结果
        return rows;
    }

    @Override
    public void saveRoleInfo(SysRole entity, Integer[] menuIds) {
        //1.参数有效性校验
        if (entity == null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getRoleName()))
            throw new IllegalArgumentException("角色名不允许为空");
        if (menuIds == null || menuIds.length == 0)
            throw new ServiceException("必须为角色分配权限");
        if (entity.getDataScope() == null || "".equals(entity.getDataScope()))
            throw new ServiceException("必须为角色分配数据范围");
        int row = sysRoleDao.getRoleInfoRowCount(entity.getRoleName());
        if (row > 0)
            throw new ServiceException("角色已经存在,请查询");
        entity.setStatus("0");
        entity.setDelFlag("0");
        entity.setCreatedUser(ShiroUtils.getUsername());
        entity.setCreatedTime(new Date());
        //2.保存角色自身信息
        int rows = sysRoleDao.insertRoleInfo(entity);
        //3.保存角色菜单关系数据
        sysRoleMenuDao.insertSysRoleMenu(entity.getRoleId(), menuIds);
        //4.返回业务结果
        if(rows == 0)
            throw new ServiceException("保存失败");
    }

    @Override
    public void removeRoleInfo(Integer roleId) {
        //1.参数校验
        if (roleId == null || roleId < 1)
            throw new IllegalArgumentException("id值无效");
        //2.删除关系数据
        sysRoleMenuDao.deleteSysRoleMenuByRoleId(roleId);
        sysUserRoleDao.deleteSysUserRoleByRoleId(roleId);
        //3.删除自身信息
        int rows = sysRoleDao.deleteSysRoleInfo(roleId);
        //4.返回结果
        if(rows == 0)
            throw new ServiceException("删除失败");
    }

    @Override
    public JsonResult findPageRoleInfoByRoleName(String roleName, Integer page, Integer limit) {
        //1.对参数进行有效性验证
        if (page == null || page < 1)
            throw new IllegalArgumentException("页码值无效");
        //2.查询记录总数并验证
        int rowCount = sysRoleDao.getRoleInfoLikeRowCount(roleName);
        if (rowCount == 0)
            throw new ServiceException("没有对应的记录");
        //3.查询当前页记录
        int startIndex = (page - 1) * limit;
        List<SysRole> records = sysRoleDao.selectRoleInfoPage(roleName, startIndex, limit);
        //4.封装结果并返回.
        return new JsonResult(page, limit, rowCount, records);
    }

}
