package com.tedu.sois.stu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.sois.stu.entity.ClassTable;
import com.tedu.sois.stu.entity.StuCrmManage;

import java.util.List;
import java.util.Set;

public interface StuCrmManageDao extends BaseMapper<StuCrmManage> {

    /**
     * 把CRM导出管理学员信息表写入数据库
     * CRM的编号作为索引避免导入重复数据
     * @param list SysStuCrmManage 集合
     * @return 受影响行数
     */
    Integer insertStuCrmManage(List<StuCrmManage> list);

    /**
     * 插入班级信息
     * @return
     */
    int insertStuClass(Set<ClassTable> date);

    /**
     * 查询最近一月的班级名称
     * @return 班级名称集合
     */
    List<String> selectClassNumAllList();
}
