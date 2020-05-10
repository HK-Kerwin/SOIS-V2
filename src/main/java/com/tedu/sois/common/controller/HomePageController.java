package com.tedu.sois.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 返回主页控制层
 * @author LYS
 */
@Controller
@RequestMapping("home/")
public class HomePageController {


    /**
     * 返回主要页面
     * @return
     */
    @RequestMapping("console")
    public String doGetConsolePage() {
        return "home/console";
    }

    /**
     * 返回数据展示页面
     * @return
     */
    @RequestMapping("show_data_page")
    public String doGetHomePage() {
        return "home/show_data_page";
    }
}
