package com.tedu.sois.stu.service;

import com.tedu.sois.common.vo.PageObject;
import com.tedu.sois.stu.entity.StuBaseInfo;

import java.util.List;


public interface StuInfoHandleService {

    /**
     * 根据班级或者教室查询学生信息并且分页
     * @param stuName 姓名
     * @param stuClass 班级
     * @param classRoom 教室
     * @param pageCurrent
     * @return
     */
    PageObject<StuBaseInfo> findPageObjects(String stuName, String stuClass,String classRoom,Integer pageCurrent);

    /**
     * 根据Id查询学生信息
     * @param stuId
     * @return 学生实体对象
     */
    StuBaseInfo findObjectById(Integer stuId);


    /**
     * 修改学生信息
     * @param entity 实体对象
     * @return 受影响行数
     */
    int updateInfoById(StuBaseInfo entity);

}
