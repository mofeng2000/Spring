package com.luoli.web;

import com.luoli.config.SpringCofiguration;
import com.luoli.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {


    public static void main(String[] args) {
       // ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringCofiguration.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }

}
