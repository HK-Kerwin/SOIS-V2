package com.tedu.sois.sys.service;

import java.util.List;
import java.util.Map;

import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.entity.SysMenu;

public interface SysMenuService {
	
	  
      List<Node> findZtreeMenuNodes();
	  List<Map<String,Object>> findObjects();
	  int deleteObject(Integer id);
	  int saveObject(SysMenu entity);
	  int updateObject(SysMenu entity);
	  
}
