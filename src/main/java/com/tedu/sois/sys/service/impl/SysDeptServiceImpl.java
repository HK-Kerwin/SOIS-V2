package com.tedu.sois.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tedu.sois.common.util.ShiroUtils;
import com.tedu.sois.sys.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.dao.SysDeptDao;
import com.tedu.sois.sys.entity.SysDept;
import com.tedu.sois.sys.service.SysDeptService;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptDao sysDeptDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void saveSysDeptInfo(SysDept entity) {
        //1.合法验证
        if (entity == null)
            throw new ServiceException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getDeptName()))
            throw new ServiceException("部门不能为空");
        int countByName = sysDeptDao.selectDeptInfoByName(entity.getDeptName());
        if (countByName > 0)
            throw new ServiceException("部门已经存在");
        entity.setCreatedUser(ShiroUtils.getUsername());
        entity.setCreatedTime(new Date());
        //2.保存数据
        System.err.println(entity);
        int rows = sysDeptDao.insertDeptInfo(entity);
        if(rows==0)
            throw new ServiceException("新增失败");
    }

    @Override
    public void removeSysDeptInfo(Integer deptId) {
        //1.合法性验证
        if (deptId == null || deptId <= 0)
            throw new ServiceException("数据不合法,id=" + deptId);
        //2.执行删除操作
        //2.1判定此id对应的菜单是否有子元素
        int childCount = sysDeptDao.getChildCount(deptId);
        if (childCount > 0)
            throw new ServiceException("此元素有子元素，不允许删除");
        //2.2判定此部门是否有用户
        int userCount=sysUserDao.getUserCountByDeptId(deptId);
        if(userCount>0)
            throw new ServiceException("此部门有员工，不允许对部门进行删除");
        //2.2判定此部门是否已经被用户使用,假如有则拒绝删除
        //2.3执行删除操作
        int rows = sysDeptDao.deleteDeptInfoById(deptId);
        if (rows == 0)
            throw new ServiceException("此信息可能已经不存在");
    }

    @Override
    public void modifySysDeptInfo(SysDept entity) {
        //1.合法验证
        if (entity == null)
            throw new ServiceException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getDeptName()))
            throw new ServiceException("部门不能为空");
        entity.setModifiedUser(ShiroUtils.getUsername());
        entity.setModifiedTime(new Date());
        int rows;
        //2.更新数据
        try {
            rows = sysDeptDao.updateDeptInfo(entity);
            if (rows == 0)
                throw new ServiceException("更新失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public SysDept findSysDeptInfoByRoleId(Integer roleId) {
        return sysDeptDao.selectDeptInfoById(roleId);
    }

    @Override
    public List<Map<String, Object>> findDeptInfoList() {
        List<Map<String, Object>> list = sysDeptDao.selectDeptInfoList();
        if (list == null || list.size() == 0)
            throw new ServiceException("没有部门信息");
        return list;
    }

    @Override
    public List<Node> findZTreeDeptNodes() {
        List<Node> list = sysDeptDao.findZTreeNodes();
        if (list == null || list.size() == 0)
            throw new ServiceException("没有部门信息");
        list = treeSelect(list,0);
        return list;
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


}
