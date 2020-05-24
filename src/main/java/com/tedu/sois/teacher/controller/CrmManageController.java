package com.tedu.sois.teacher.controller;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.teacher.service.CrmManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("crm/")
public class CrmManageController {

    @Autowired
    private CrmManageService crmManageService;

    /**
     * 更新CRM学生信息表数据
     * 会更新班级表和CRM学生信息表
     * @param excelFile
     * @return
     */
    @PostMapping("uploadExcel")
    public JsonResult uploadExcel(MultipartFile excelFile){
        crmManageService.addCrmExcel(excelFile);
        System.err.println("数据更新成功");
        return new JsonResult("数据更新成功");
    }


    /**
     * 查询crm下载的Excel文件中包含的班级信息
     * 后续老师自行添加
     * @return
     */
    @GetMapping("findStuClass")
    public JsonResult findStuClass(){
        return new JsonResult(crmManageService.showClassNumAllList());
    }

    @RequestMapping("findClassDirectionByClassName")
    public JsonResult findClassDirectionByClassName(String className){
        if (className == null || "".equals(className))
            return new JsonResult("此班级没有方向,请尽快添加","");
        String direction = crmManageService.findClassDirectionByClassName(className);
        return new JsonResult(direction,direction);
    }

}
