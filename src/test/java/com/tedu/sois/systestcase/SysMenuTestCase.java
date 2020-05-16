package com.tedu.sois.systestcase;

import com.tedu.sois.sys.dao.SysRoleMenuDao;
import com.tedu.sois.sys.service.SysMenuService;
import com.tedu.sois.sys.service.SysRoleService;
import com.tedu.sois.sys.vo.SysRoleMenuVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class SysMenuTestCase {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 角色业务层接口
     */
    @Autowired
    private SysRoleService sysRoleService;


    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Test
    public void find(){
        List<Map<String, Object>> menuList = sysMenuService.findMenuList();
        for (Map map : menuList) {
            System.out.println(map);
        }
    }
    @Test
    public void findById(){
        Integer roleIds = 47;
        SysRoleMenuVo data = sysRoleService.findRoleAndMenuInfoByRoleId(roleIds);
        System.err.println(data);
    }
}
