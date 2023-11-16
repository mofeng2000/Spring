package com.luoli.dao.impl;

import com.luoli.dao.UserDao;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.luoli.dao.impl.UserDaoImpl"></bean>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running..");
    }
}
