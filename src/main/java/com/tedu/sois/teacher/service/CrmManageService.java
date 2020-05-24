package com.tedu.sois.teacher.service;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CrmManageService {

    /**
     * 把CRM导出管理学员信息表，读取后整理写入数据库
     * @param file 传入表格文件
     * @return 受影响行数
     */
    void addCrmExcel(MultipartFile file);

    /**
     * 查询所有的班级名称
     * @return 全部班级名集合
     */
    List<String> showClassNumAllList();


    String findClassDirectionByClassName(String className);
}