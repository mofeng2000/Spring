package com.luoli.test;

import com.luoli.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    //测试Scope属性
    public void test1(){

        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        //UserDao userDao2 = (UserD ao) app.getBean("userDao");
        System.out.println(userDao1);
       // System.out.println(userDao2);
       // app.close();
    }
}
