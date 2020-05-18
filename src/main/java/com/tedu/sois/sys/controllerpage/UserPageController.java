package com.tedu.sois.sys.controllerpage;

import com.tedu.sois.common.util.ShiroUtils;
import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.sys.entity.SysRole;
import com.tedu.sois.sys.entity.SysUser;
import com.tedu.sois.sys.service.SysDeptService;
import com.tedu.sois.sys.service.SysRoleService;
import com.tedu.sois.sys.service.SysUserService;
import com.tedu.sois.sys.vo.SysRoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户个人页面跳转控制层,在跳转时通过model携带数据
 *
 * @author LYS
 */
@Controller
@RequestMapping("user/")
public class UserPageController {


    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 用户获取用户个人信息HTML页面
     *
     * @param userId 用户ID
     * @param model
     * @return
     */
    @RequestMapping("getUserInfoPage")
    public String getUserInfoPage(Long userId, Model model) {
        SysUser user = ShiroUtils.getUser();
        List<SysRole> onLineUserRole = sysRoleService.findRoleByUserId(user.getUserId());
        if (userId != null && userId > 0) {
            user = sysUserService.findUserInfoById(userId);
            userId = user.getUserId();
        } else {
            userId = user.getUserId();
        }
        for (SysRole sysRole: onLineUserRole) {
            if ("admin".equals(sysRole.getRoleKey())){
                onLineUserRole = sysRoleService.findRoleInfoList();
                break;
            }
        }
        List<SysRole> role = sysRoleService.findRoleByUserId(userId);
        Integer[] optRoleId = new Integer[role.size()];
        for (int i = 0; i < role.size(); i++) {
            optRoleId[i] = role.get(i).getRoleId();
        }
        model.addAttribute("role", onLineUserRole);
        model.addAttribute("optRoleId", optRoleId);
        model.addAttribute("userInfo", user);
        return "user/user_info";
    }

    /**
     * 用户获取修改密码HTML页面
     *
     * @return
     */
    @RequestMapping("getModifyPasswordPage")
    public String getModifyPasswordPage() {
        return "user/modify_password";
    }

}
