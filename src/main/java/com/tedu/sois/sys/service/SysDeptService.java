package com.tedu.sois.sys.service;

import java.util.List;
import java.util.Map;

import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.entity.SysDept;

public interface SysDeptService {
	 List<Map<String,Object>> findObjects();
	 List<Node> findZTreeNodes();
	 int saveObject(SysDept entity);
	 int updateObject(SysDept entity);
	 int deleteObject(Integer id);
}
