package com.tedu.sois.stu.controller;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.teacher.service.StuCrmManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("crm/")
public class StuCrmManageController {

    @Autowired
    private StuCrmManageService service;

    /**
     * 更新CRM学生信息表数据
     * 会更新班级表和CRM学生信息表
     * @param excelFile
     * @return
     */
    @PostMapping("uploadExcel")
    public JsonResult uploadExcel(MultipartFile excelFile){
        service.addCrmExcel(excelFile);
        System.out.println("数据更新成功");
        return new JsonResult("数据更新成功");
    }


    /**
     * 查询crm下载的Excel文件中包含的班级信息
     * 后续老师自行添加
     * @return
     */
    @GetMapping("findStuClass")
    public JsonResult findStuClass(){
        return new JsonResult(service.showClassNumAllList());
    }
}
