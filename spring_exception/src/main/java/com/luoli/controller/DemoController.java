package com.luoli.controller;

import com.luoli.exception.MyException;
import com.luoli.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class DemoController {


   private DemoService demoService;

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping(value = "/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show running......");
        demoService.show1();
        //demoService.show2();
        //demoService.show3();
        //demoService.show4();
       // demoService.show5();
        return "index";
    }

}
