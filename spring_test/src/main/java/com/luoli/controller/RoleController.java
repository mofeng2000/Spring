package com.luoli.controller;

import com.luoli.pojo.Role;
import com.luoli.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

//    public void setRoleService(RoleService roleService) {
//        this.roleService = roleService;
//    }


    @RequestMapping("/save")
    /**
     * 存储角色信息
     */
    public String save(Role role){
       roleService.save(role);
        return "redirect:/role/list";
    }

    /**
     * 查询角色信息
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();

       List<Role> roleList= roleService.list();
       //设置模型
       modelAndView.addObject("roleList",roleList);
       //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
