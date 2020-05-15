package com.tedu.sois.sys.service;

import java.util.List;
import java.util.Map;

import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.entity.SysMenu;

public interface SysMenuService {

    /**
     * 查询节点树
     * @return
     */
    List<Node> findZtreeMenuNodes();

    /**
     * 查询菜单及子菜单信息
     *
     * @return
     */
    List<Map<String, Object>> findMenuList();

    /**
     * 根据菜单id删除菜单信息
     * @param menuId
     * @return
     */
    int deleteSysMenuInfoById(Integer menuId);

    void saveSysMenuInfo(SysMenu entity);

    int modifySysMenuInfo(SysMenu entity);

}
