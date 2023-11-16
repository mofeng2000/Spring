package com.luoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {

    //项目执行顺序2
    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行......");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","luoli");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
