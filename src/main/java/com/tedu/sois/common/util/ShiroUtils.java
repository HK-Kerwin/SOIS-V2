package com.tedu.sois.common.util;

import org.apache.shiro.SecurityUtils;

import com.tedu.sois.sys.entity.SysUser;

public class ShiroUtils {
   public static String getUsername() {
	   return getUser().getUserName();
   }
   /**获取登录用户*/
   public static SysUser getUser() {
	   return (SysUser) SecurityUtils.getSubject().getPrincipal();
   }
}
