package com.tedu.sois.stu.controller;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.common.vo.PageObject;
import com.tedu.sois.stu.entity.StuBaseInfo;
import com.tedu.sois.stu.service.StuInfoHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员请求控制层
 */

@RestController
@RequestMapping("stuInfo/")
public class StuInfoHandleController {

    @Autowired
    private StuInfoHandleService service;

    /**
     * 修改学生信息
     * @param entity 实体对象
     * @return 受影响行数
     */
    @PostMapping("doUpdateStuInfoById")
    public JsonResult doUpdateStuInfoById(StuBaseInfo entity){
        int row = service.updateInfoById(entity);
        if (row == 0) {
            new JsonResult(0,"修改失败!");
        }
        return new JsonResult("保存成功!");
    }


    /**
     * 根据班级号或者教室号返回学生信息并且分页
     * @param stuClass 班级号
     * @param classRoomNum 教室号
     * @param pageCurrent
     * @return
     */
    @GetMapping("doFindPageNameOrClassOrRoom")
    public JsonResult doFindPageNameOrClassOrRoom(
            @RequestParam("stuName") String stuName,
            @RequestParam("stuClass") String stuClass,
            @RequestParam("classRoomNum") String classRoomNum,
            @RequestParam("pageCurrent")Integer pageCurrent) {
        PageObject<StuBaseInfo> pageObjects = service.findPageObjects(stuName,stuClass,classRoomNum,pageCurrent);
        return new JsonResult(pageObjects);
    }

    /**
     * 根据Id查询学生信息
     * @param stuId
     * @return 学生实体对象
     */
    @GetMapping("doFindStuInfoById")
    public JsonResult doFindStuInfoById(@RequestParam("stuId")Integer stuId) {
        return new JsonResult(service.findObjectById(stuId));
    }


}
