package com.tedu.sois.stu.controller;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.stu.service.StuCrmManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("crm/")
public class StuCrmManageController {

    @Autowired
    private StuCrmManageService service;

    @PostMapping("uploadExcel")
    public JsonResult uploadExcel(MultipartFile excelFile){
        service.addCrmExcel(excelFile);
        System.out.println("数据更新成功");
        return new JsonResult("数据更新成功");
    }


    /**
     * 查询crm下载的Excel文件中包含的班级数
     * 时间在当前时间4个月内
     * @return
     */
    @GetMapping("findStuClass")
    public JsonResult findStuClass(){
        return new JsonResult(service.showClassNumAllList());
    }
}
