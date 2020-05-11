package com.tedu.sois.sys.service;

import java.util.List;
import java.util.Map;

import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.entity.SysMenu;

public interface SysMenuService {


    List<Node> findZtreeMenuNodes();

    /**
     * 查询菜单及子菜单信息
     *
     * @return
     */
    List<Map<String, Object>> findMenuList();

    int deleteObject(Integer menuId);

    int saveObject(SysMenu entity);

    int updateObject(SysMenu entity);

}
