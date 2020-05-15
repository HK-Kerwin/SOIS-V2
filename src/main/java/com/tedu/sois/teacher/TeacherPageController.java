package com.tedu.sois.teacher;

import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.common.util.ShiroUtils;
import com.tedu.sois.stu.entity.StuBaseInfo;
import com.tedu.sois.stu.service.StuBaseInfoService;
import com.tedu.sois.stu.service.StuCrmManageService;
import com.tedu.sois.sys.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("teacher/")
public class TeacherPageController {

    @Autowired
    private StuBaseInfoService stuBaseInfoService;

    @RequestMapping("doGetStuInfoPageForTeacher")
    public String doGetStuInfoPageForTeacher(String indexSearch,Model model) {
        List<String> list = stuBaseInfoService.showStuClassNumList();
        model.addAttribute("stuClass",list);
        //System.err.println("indexSearch = " + indexSearch);
        //if(indexSearch != null && !"".equals(indexSearch)){
           // Map<String,String> searchResult = stuBaseInfoService.findStuInfoBySearch(indexSearch);
            //System.out.println(searchResult);
            //model.addAttribute("searchResult",searchResult);
        //}
        return "teacher/stuInfo_list";
    }
}
