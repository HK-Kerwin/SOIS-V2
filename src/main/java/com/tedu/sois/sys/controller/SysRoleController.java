package com.tedu.sois.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.sys.entity.SysRole;
import com.tedu.sois.sys.service.SysRoleService;

@RestController
@RequestMapping("role/")
public class SysRoleController {

    @Autowired //has a
    private SysRoleService sysRoleService;

    @GetMapping("doFindRoles")
    public JsonResult doFindRoles() {
        return new JsonResult(sysRoleService.findObjects());
    }

    /**
     * 根据角色ID查询角色以及角色对应的菜单id
     * @param roleId
     * @return
     */
    @GetMapping("doFindObjectById")
    public JsonResult getRoleAndMenuInfoByRoleId(Integer roleId) {
        return new JsonResult(sysRoleService.findRoleAndMenuInfoByRoleId(roleId));
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysRole entity, Integer[] menuIds) {
        sysRoleService.updateObject(entity, menuIds);
        return new JsonResult("update ok");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysRole entity, Integer[] menuIds) {
        sysRoleService.saveObject(entity, menuIds);
        return new JsonResult("save ok");
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        sysRoleService.deleteObject(id);
        return new JsonResult("delete ok");
    }

    /**
     * 根据角色名字查询,如果没有,则返回全部
     * @param roleName 角色名
     * @param page 页码
     * @param limit 数量
     * @return
     */
    @RequestMapping("doFindPageRoleInfoByRoleName")
    public JsonResult doFindPageRoleInfoByRoleName(String roleName, Integer page, Integer limit) {
        return sysRoleService.findPageRoleInfoByRoleName(roleName,page,limit);
    }
}
