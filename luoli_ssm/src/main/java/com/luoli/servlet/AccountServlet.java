package com.luoli.servlet;

import com.luoli.pojo.Account;
import com.luoli.service.AccountService;

import com.luoli.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller//标识为web控制器
@RequestMapping("/account")//设置页面访问路径
public class AccountServlet {

    //注入accountService

    //    @Qualifier("accountService")
    //@Resource(name = "accountService")

//    private final AccountService accountService;
//
//    public AccountServlet(AccountService accountService) {
//        this.accountService = accountService;
//    }

    //保存
    @RequestMapping(value = "/add", produces = "text/html;charset=UTF-8")
    @ResponseBody//阻止页面跳转
    public String add(Account account) {
        AccountService accountService = new AccountServiceImpl();
        accountService.add(account);
        return "保存成功";
    }

    @RequestMapping("/selectAll")
    public ModelAndView selectAll() {
        AccountService accountService = new AccountServiceImpl();

        List<Account> accountList = accountService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList", accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
