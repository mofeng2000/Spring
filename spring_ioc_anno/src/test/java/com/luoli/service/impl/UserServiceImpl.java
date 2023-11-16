package com.luoli.service.impl;

import com.luoli.dao.UserDao;
import com.luoli.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.luoli.service.impl.UserServiceImpl">  </bean>
//@Component("userService")
@Service("userService")
//@Scope("prototype")
//@Scope("singleton")



public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Value("${jdbc.driver}")
    private String driver;

       // <property name="userDao" ref="userDao"></property>
//@Autowired//按照数据类型spring容器进行匹配
//@Qualifier("userDao")//是按照id值从容器进行匹配，但是要和Autowired一起使用
@Resource(name = "userDao")//Resource相当于Autowired+Qualifier
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println(driver);
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("对象初始化");
    }
    @PreDestroy
    public void destory(){
        System.out.println("对象销毁");
    }
}
