package com.luoli.service.impl;

import com.luoli.dao.UserDao;
import com.luoli.service.UserService;



public class UserServiceImpl implements UserService {
    private UserDao userDao;

       // <property name="userDao" ref="userDao"></property>
//@Autowired//按照数据类型spring容器进行匹配
//@Qualifier("userDao")//是按照id值从容器进行匹配，但是要和Autowired一起使用
//@Resource(name = "userDao")//Resource相当于Autowired+Qualifier
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {

        userDao.save();
    }
}
