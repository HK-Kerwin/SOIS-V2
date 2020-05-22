package com.tedu.sois.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.fastjson.JSON;
import com.tedu.sois.teacher.entity.ClassInfo;
import com.tedu.sois.teacher.entity.StuCrmManage;
import com.tedu.sois.teacher.entity.StuCrmManageTemporary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StuCrmManageTemporaryListener extends AnalysisEventListener<StuCrmManageTemporary> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StuCrmManageTemporaryListener.class);

    private int index = 0;

    /**
     * 每隔1000条存储数据库，然后清理list ，方便内存回收
     */
//    private static final int BATCH_COUNT = 1000;

    List<StuCrmManage> list = new ArrayList<>();

    Set<ClassInfo> seriesClassAll = new HashSet<>();


    @Override
    public void invoke(StuCrmManageTemporary crm, AnalysisContext analysisContext) {

        //存储班级信息
        ClassInfo ct = new ClassInfo();
        String crmClass = crm.getColumn3();
        String createdTime = crm.getColumn22();//创建时间
        SimpleDateFormat sdfCreateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (crmClass != null && !"".equals(crmClass)){
            System.out.println(crm);
            ct.setClassName(crmClass);
            ct.setClassDirection(crmClass.substring(0,3));
            try {
                ct.setCreatedTime(sdfCreateTime.parse(createdTime));
            } catch (ParseException e) {
                LOGGER.info("时间解析错误createdTime:{}",createdTime);
            }
            seriesClassAll.add(ct);
        }


        //存储CRM学员信息
        if(!("正式学员".equals(crm.getColumn4()) ||
                "毕业学员".equals(crm.getColumn4())))
            return;
        index++;
        if(index % 500 == 0)
            LOGGER.info("解析到"+index+"条数据:{}", JSON.toJSONString(crm));
        StuCrmManage stu = new StuCrmManage();
        stu.setCrmId(crm.getColumn0());
        stu.setCrmStuName(crm.getColumn1());
        stu.setSeriesClass(crm.getColumn2());
        stu.setCrmClass(crmClass);
        stu.setStuState(crm.getColumn4());
        stu.setContractSendType(crm.getColumn5());
        stu.setNeedCost(crm.getColumn6());
        stu.setCostAll(crm.getColumn9());
        //创建时间格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //进行判断防止getColumn为null,在parse时出现 java.lang.NullPointerException
        String EnterClassTime = crm.getColumn10();//进班时间
        if (EnterClassTime == null || "".equals(EnterClassTime)){
            stu.setEnterClassTime(null);
        } else {
            try {
                stu.setEnterClassTime(sdf.parse(EnterClassTime));
            } catch (ParseException e) {
                LOGGER.info("时间解析错误EnterClassTime:{}",EnterClassTime);
            }
        }
        String monthlyDate = crm.getColumn17();//月报时间
        if (monthlyDate == null || "".equals(monthlyDate)){
            stu.setMonthlyTime(null);
        } else {
            try {
                stu.setMonthlyTime(sdf.parse(monthlyDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        stu.setTeachingCenter(crm.getColumn18());
        stu.setSalesCenter(crm.getColumn19());
        stu.setConsultName(crm.getColumn20());
        stu.setCreateName(crm.getColumn21());


        if (createdTime == null || "".equals(createdTime)){
            stu.setCreatedTime(null);
        } else {
            try {
                stu.setCreatedTime(sdfCreateTime.parse(createdTime));
            } catch (ParseException e) {
                LOGGER.info("时间解析错误createdTime:{}",createdTime);
            }
        }
        list.add(stu);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        LOGGER.info("所有数据解析完毕");
        index = 0;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) {
        LOGGER.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;
            LOGGER.error("第{}行，第{}列解析异常", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex());
        }
    }

    public List<StuCrmManage> getList(){
        return list;
    }

    public Set<ClassInfo> getSeriesClassAll(){
        return seriesClassAll;
    }
}
