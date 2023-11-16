package com.luoli.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    //在目标方法之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String param = request.getParameter("param");
        if("yes".equals(param)){
            return true;//false表示后面的方法不执行
        }
        else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;
        }


        //项目执行顺序1
    }
    //在目标方法执行之后，视图对象放回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        modelAndView.addObject("name","luoyangligong");
        //项目执行顺序3
    }
    //在流程都执行完毕后，执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        //项目执行顺序4
    }
}
