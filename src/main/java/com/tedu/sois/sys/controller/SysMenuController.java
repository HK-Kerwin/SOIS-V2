package com.tedu.sois.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.sys.entity.SysMenu;
import com.tedu.sois.sys.service.SysMenuService;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("menu/")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysMenu entity) {
        sysMenuService.updateObject(entity);
        return new JsonResult("update ok");
    }

    @PostMapping("doSaveObject")
    public JsonResult doSaveObject(SysMenu entity) {
        sysMenuService.saveObject(entity);
        return new JsonResult("save ok");
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        sysMenuService.deleteObject(id);
        return new JsonResult("delete ok");
    }

    @GetMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes() {
        return new JsonResult(sysMenuService.findZtreeMenuNodes());
    }

    @RequestMapping("doFindMenuList")
    public JsonResult doFindMenuList() {
        return new JsonResult(sysMenuService.findMenuList());
    }
}






