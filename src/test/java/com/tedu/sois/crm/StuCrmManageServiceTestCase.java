package com.tedu.sois.crm;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.common.listener.StuCrmManageTemporaryListener;
import com.tedu.sois.stu.dao.StuCrmManageDao;
import com.tedu.sois.stu.entity.ClassTable;
import com.tedu.sois.stu.entity.StuCrmManage;
import com.tedu.sois.stu.entity.StuCrmManageTemporary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class StuCrmManageServiceTestCase {
    @Autowired
    private StuCrmManageDao dao;

    @Test
    public void uploadExcel(){
        StuCrmManageTemporaryListener listener = new StuCrmManageTemporaryListener();
        EasyExcel.read("E:\\ChromeDownload\\学员管理_20200425060432.xls", StuCrmManageTemporary.class, listener).sheet().doRead();


        List<StuCrmManage> list = listener.getList();
        System.out.println(list);
        int row1 = dao.insertStuCrmManage(list);
        if (row1 == 0)
            throw new ServiceException("基本信息无更新内容");

        Set<ClassTable> seriesClassAll = listener.getSeriesClassAll();
        int row2 = dao.insertStuClass(seriesClassAll);
        if (row2 == 0)
            throw new ServiceException("班级号信息无更新内容");
    }
}
