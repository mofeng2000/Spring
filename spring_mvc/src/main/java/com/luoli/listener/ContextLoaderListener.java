package com.luoli.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();
        //读取web.xml的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");


        ApplicationContext app=new ClassPathXmlApplicationContext(contextConfigLocation);

        //将spring上下文对象存储到servletContext域中

        servletContext.setAttribute("app",app);
        System.out.println( "spring容器创建完毕");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
