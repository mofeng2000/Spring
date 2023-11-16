package com.luoli.demo;

import com.luoli.dao.UserDao;
import com.luoli.service.UserService;
import com.luoli.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        UserService userService=new UserServiceImpl();
//        userService.save();
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");

        userService.save();

    }
}
