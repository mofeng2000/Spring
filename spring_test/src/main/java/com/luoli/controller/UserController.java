package com.luoli.controller;

import com.luoli.pojo.Role;
import com.luoli.service.RoleService;
import com.luoli.service.UserService;
import com.luoli.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller

@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/login")
    public String login(String username, String password , HttpSession session){
        User user=userService.login(username,password);
        if(user!=null){
            //登陆成功 将user存储到session中
            session.setAttribute("user",user);
            return "redirect:/index.jsp";

        }
        return "redirect:/login.jsp";

    }

    @RequestMapping("/list")
    public ModelAndView list(){
      List<User> userList=  userService.list();
      ModelAndView modelAndView=new ModelAndView();
      modelAndView.addObject("userList",userList);
      modelAndView.setViewName("user-list");
      return modelAndView ;
    }

    @Autowired
    private RoleService roleService;

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView ;
    }

    @RequestMapping("/save")
    public String save(User user,Long [] roleIds){

        List<Role> roleList = userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){

       userService.del(userId);
        return "redirect:/user/list";
    }
}
