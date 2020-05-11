package com.tedu.sois.systestcase;

import com.tedu.sois.sys.service.SysMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class SysMenuTestCase {

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void find(){
        List<Map<String, Object>> menuList = sysMenuService.findMenuList();
        for (Map map : menuList) {
            System.out.println(map);
        }
    }
}
