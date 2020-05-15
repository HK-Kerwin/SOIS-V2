package com.tedu.sois.teacher;

import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.stu.entity.StuBaseInfo;
import com.tedu.sois.stu.service.StuBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher/")
public class TeacherController {

    @Autowired
    private StuBaseInfoService stuBaseInfoService;

    /**
     * 分页查询所有学生信息
     * @param stuBaseInfo 查询条件封装到学生对象
     * @param page 页码
     * @param limit 查询数量
     * @return
     */
    @PostMapping("doFindStuInfoList")
    public JsonResult doFindStuInfoList(StuBaseInfo stuBaseInfo,Integer page, Integer limit ) {
        System.err.println(stuBaseInfo);
        return stuBaseInfoService.showStuInfoList(stuBaseInfo,page,limit);
    }
}
