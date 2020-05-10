package com.tedu.sois.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.sys.entity.SysDept;
import com.tedu.sois.sys.service.SysDeptService;

@RestController
@RequestMapping("dept/")
public class SysDeptController {
	@Autowired
	private SysDeptService sysDeptService;
	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects() {
		return new JsonResult(sysDeptService.findObjects());
	}
	@RequestMapping("doFindZTreeNodes")
	public JsonResult doFindZTreeNodes() {
		return new JsonResult(sysDeptService.findZTreeNodes());
	}
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysDept entity){
		sysDeptService.updateObject(entity);
	    return new JsonResult("update ok");
	}
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysDept entity){
		sysDeptService.saveObject(entity);
		return new JsonResult("save ok");
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysDeptService.deleteObject(id);
		return new JsonResult("delete ok");
	}
}
