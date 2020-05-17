package com.tedu.sois.common.controller;

import com.tedu.sois.common.util.ShiroUtils;
import com.tedu.sois.sys.entity.SysUser;
import com.tedu.sois.sys.service.SysMenuService;
import com.tedu.sois.sys.vo.SysUserMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PageController {

    /**
     * 菜单业务接口
     */
    @Autowired
    private SysMenuService sysMenuService;
    
    /**
     * 返回主页
     *
     * @return
     */
    @RequestMapping("")
    public String goToIndex(Model model) {
        SysUser user = ShiroUtils.getUser();
        if (user != null) {
            model.addAttribute("userData", user);
            List<SysUserMenuVo> userMenus = sysMenuService.findMenusByUserId(user.getUserId());
            model.addAttribute("userMenus", userMenus);
        } else {
            user = new SysUser();
            user.setUserName("请登录");
            user.setAvatar("dist/layuiadmin/img/defualt.png");
            model.addAttribute("userData", user);
        }
        return "index";
    }


    @RequestMapping("doLoginUI")
    public String doLoginUI(Model model) {
        SysUser user = ShiroUtils.getUser();
        if (user != null) {
            model.addAttribute("userData", user);
            return "error_index";
        } else {
            user = new SysUser();
            user.setUserName("请登录");
            model.addAttribute("userData", user);
        }
        return "login";
    }

    @RequestMapping("doErrorUI")
    public String doErrorUI() {
        return "error";
    }


    /**返回日志列表页面*/
//	 @RequestMapping("log/log_list")
//	 public String doLogUI() {
//		 return "stu/log_list";
//	 }
    /**返回菜单列表页面*/
//	 @RequestMapping("menu/menu_list")
//	 public String doMenuUI() {
//		 return "stu/menu_list";
//	 }


    /**
     * 返回左侧列表网页-备用
     * @return
     */
    @RequestMapping("common/")
    public String doCommonPage() {
        return "common/index_li_page";
    }
}
