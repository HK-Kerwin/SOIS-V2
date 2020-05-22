package com.tedu.sois.teacher.controller;

import com.tedu.sois.common.exception.ServiceException;
import com.tedu.sois.stu.service.StuBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
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
        if(indexSearch != null && !"".equals(indexSearch)){

            String[] result = indexSearch.split(":");
            if (result.length != 2)
                throw new ServiceException("输入内容有误,请检查");

            Map<String,String> map = new HashMap<>();

            switch (result[0]){
                case "stuName":
                    map.put("stuName",result[1]);
                    break;
                case "phoneNumber":
                    map.put("phoneNumber",result[1]);
                    break;
                case "idCard":
                    map.put("idCard",result[1]);
                    break;
            }

            model.addAttribute("searchResult",map);
        }
        return "teacher/stuInfo_list";
    }
}
