package com.luoli.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luoli.domain.User;
import com.luoli.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //多文件上传数组
    @RequestMapping(value = "/quick24")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save24(String username ,MultipartFile[] uploadFile) throws Exception {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            //获取上传文件的名称
            String originalFilename = multipartFile.getOriginalFilename();
            //下载文件到本地磁盘
            multipartFile.transferTo(new File("C:\\upload\\"+originalFilename));
        }
    }

    //多文件上传
    @RequestMapping(value = "/quick23")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save23(String username ,MultipartFile uploadFile1,MultipartFile uploadFile2) throws Exception {
        System.out.println(username);
        //获取上传文件的名称
        String originalFilename1 = uploadFile1.getOriginalFilename();
        String originalFilename2 = uploadFile2.getOriginalFilename();
        //下载文件到本地磁盘
        uploadFile1.transferTo(new File("C:\\upload\\"+originalFilename1));
        uploadFile2.transferTo(new File("C:\\upload\\"+originalFilename2));
    }

    //单文件上传
    @RequestMapping(value = "/quick22")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save22(String username ,MultipartFile uploadFile) throws Exception {
        System.out.println(username);
        //获取上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        //下载文件到本地磁盘
        uploadFile.transferTo(new File("C:\\upload\\"+originalFilename));
    }

    //获取cookie响应头
    @RequestMapping(value = "/quick21")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save21(@CookieValue(value = "JSESSIONID" , required = false)String cookie) throws Exception {
        System.out.println(cookie);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent" , required = false)String user_agent) throws Exception {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save19(HttpServletResponse response , HttpServletRequest request, HttpSession session) throws Exception {
        System.out.println(response);
        System.out.println(request);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save18(Date date) throws Exception {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save17( @PathVariable("username") String username ) throws Exception {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "luoli") String username ) throws Exception {
        System.out.println(username);
    }


    @RequestMapping(value = "/quick15")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save15(@RequestBody List<User> userList) throws Exception {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save14(VO vo) throws Exception {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save13(String [] strs ) throws Exception {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save12(User user ) throws Exception {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public void save11(String username, int age ) throws Exception {
        System.out.println(username+"==="+age);
    }
    @RequestMapping(value = "/quick10")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public User save10( ) throws Exception {
        User user=new User();
        user.setUsername("lisi2");
        user.setAge(38);

        return user;

    }
    @RequestMapping(value = "/quick9")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public String save9( ) throws Exception {
        User user=new User();
        user.setUsername("lisi");
        user.setAge(30);
        //使用json的转换工具转化成json格式字符串再返回
        ObjectMapper objectMapper=new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;

    }

    @RequestMapping(value = "/quick8")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public String save8( ) {
        return "{\"username\":\"zhangsan\",\"age\":18}";

    }

    @RequestMapping(value = "/quick7")
    @ResponseBody//告知spring框架，不进行页面跳转，直接数据响应
    public String save7( ) {
       return "hello springmvc";

    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello world");

    }
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","zhaoliu");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","wangwu");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(  ModelAndView modelAndView){

        modelAndView.setViewName("success");
        modelAndView.addObject("username","lisi");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("username","zhangsan");
      return modelAndView;
    }

    @RequestMapping(value = "/quick",method = RequestMethod.GET,params ={"username"})
    public String save(){
        System.out.println("UserController running");
        return "success";
    }
}
