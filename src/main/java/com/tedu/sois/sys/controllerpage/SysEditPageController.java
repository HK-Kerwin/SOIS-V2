package com.tedu.sois.sys.controllerpage;

import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.entity.SysMenu;
import com.tedu.sois.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 返回对应编辑页面
 * @author LYS
 */
@Controller
@RequestMapping("")
public class SysEditPageController {

    /**
     * 菜单业务层接口
     */
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 菜单编辑 界面
     * @param model
     * @return
     */
    @PostMapping("menu/edit")
    public String doGetMenuEditPage(SysMenu sysMenu, Model model) {
        model.addAttribute("menu",sysMenu);
        //这里后期可以查出parentId为0的结果,把对应的id值放入model中
        model.addAttribute("parentId",8);
        return "sys/menu_edit" ;
    }

}
