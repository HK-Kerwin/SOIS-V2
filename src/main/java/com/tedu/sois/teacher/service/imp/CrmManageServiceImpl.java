package com.tedu.sois.teacher.service.imp;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.common.listener.StuCrmManageTemporaryListener;
import com.tedu.sois.teacher.dao.StuCrmManageDao;
import com.tedu.sois.teacher.entity.ClassInfo;
import com.tedu.sois.teacher.entity.StuCrmManage;
import com.tedu.sois.teacher.entity.StuCrmManageTemporary;
import com.tedu.sois.teacher.service.CrmManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = false,
        isolation = Isolation.READ_COMMITTED, //隔离级别
        rollbackFor = Throwable.class,//什么异常回滚
        timeout = 30,//单位:秒
        propagation = Propagation.REQUIRED)//传播特性
public class CrmManageServiceImpl implements CrmManageService {

    @Value("${sois.profile}")
    private String uploadFolder;

    @Autowired
    private StuCrmManageDao stuCrmManageDao;



    @Override
    public void addCrmExcel(MultipartFile file) {
        if (file == null || file.isEmpty())
            throw new ServiceException("请选择文件");

        File upload = new File(uploadFolder);
        if (!upload.exists()){
            upload.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        if (fileName.indexOf("(") != -1){
            fileName = fileName.split("\\(")[0];
        }
        File uploadPath = new File(uploadFolder, "crm/excel/");
        System.err.println("uploadPath = " + uploadPath);
        try {
            file.transferTo(uploadPath);
        } catch (IOException e) {
            throw new ServiceException("传输出现异常,请联系管理员修复");
        }

        StuCrmManageTemporaryListener listener = new StuCrmManageTemporaryListener();
        try {
            EasyExcel.read(uploadPath, StuCrmManageTemporary.class, listener).sheet().doRead();
        } catch (ExcelAnalysisException e) {
            throw new ServiceException("文件出现异常,请查看文件是否存在加密或损坏");
        }

        List<StuCrmManage> list = listener.getList();
        System.err.println(list);
        int row1 = stuCrmManageDao.insertStuCrmManage(list);
        if (row1 == 0)
            throw new ServiceException("基本信息无更新内容");

        Set<ClassInfo> seriesClassAll = listener.getSeriesClassAll();
        int row2 = stuCrmManageDao.insertStuClassSet(seriesClassAll);
        if (row2 == 0)
            throw new ServiceException("班级号信息无更新内容");
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> showClassNumAllList() {
        return stuCrmManageDao.selectClassNameAllList();
    }

    @Transactional(readOnly = true)
    @Override
    public String findClassDirectionByClassName(String className) {
        return stuCrmManageDao.selectClassDirectionByClassName(className);
    }
}
