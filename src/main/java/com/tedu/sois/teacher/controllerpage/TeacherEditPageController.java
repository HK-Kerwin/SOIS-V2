package com.tedu.sois.teacher.controllerpage;

import com.tedu.sois.teacher.entity.ClassRoom;
import com.tedu.sois.teacher.service.CrmManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class TeacherEditPageController {

    @Autowired
    private CrmManageService crmManageService;

    @PostMapping("classRoom/doGetClassRoomEditPageForTeacher")
    public String doGetClassRoomEditPageForTeacher(ClassRoom classRoom, Model model){
        List<String> list = crmManageService.showClassNumAllList();
        model.addAttribute("classNum", list);
        if (classRoom == null){
            classRoom = new ClassRoom();
        }
        model.addAttribute("classRoom",classRoom);
        return "teacher/classroom_edit";
    }

    @RequestMapping("classTable/doGetClassTablePageForTeacher")
    public String doGetClassRoomEditPageForTeacher(Model model){
        List<String> list = crmManageService.showClassNumAllList();
        model.addAttribute("classNum", list);
        return "teacher/class_table";
    }

}
