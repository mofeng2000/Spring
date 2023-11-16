package com.luoli.web;

import com.luoli.service.UserService;
import org.springframework.context.ApplicationContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

        //ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        UserService userService = (UserService)app.getBean("userService");
        userService.save();
    }
}
