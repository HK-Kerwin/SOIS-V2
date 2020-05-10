package com.tedu.sois.stu.service.impl;

import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.common.vo.PageObject;
import com.tedu.sois.stu.dao.StuInfoHandleDao;
import com.tedu.sois.stu.entity.StuBaseInfo;
import com.tedu.sois.stu.service.StuInfoHandleService;
import com.tedu.sois.sys.vo.SysUserDeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StuInfoHandleServiceImpl implements StuInfoHandleService {

    @Autowired
    private StuInfoHandleDao dao;

    @Override
    public PageObject<StuBaseInfo> findPageObjects(String stuName, String stuClass, String classRoom, Integer pageCurrent) {
        //1.参数校验
        if (pageCurrent == null || pageCurrent < 1)
            throw new IllegalArgumentException("页码值不正确");
        //2.统计总记录数并校验
        int rowCount =  dao.getRowCount(stuName,stuClass,classRoom);
        if (rowCount == 0)
            throw new ServiceException("没有学生信息");
        //3.查询当前页记录
        int pageSize = 10;
        int startIndex = (pageCurrent - 1) * pageSize;
        List<StuBaseInfo>  records = dao.selectPageStuNameOrStuClassOrClassRoom(stuName,stuClass, classRoom,startIndex, pageSize);
        //4.封装查询结果
        return new PageObject<>(pageCurrent, pageSize, rowCount, records);
    }

    @Override
    public StuBaseInfo findObjectById(Integer stuId) {
        StuBaseInfo data = dao.selectById(stuId);
        return data;
    }

    @Override
    public int updateInfoById(StuBaseInfo entity) {
        return dao.updateById(entity);
    }

}
