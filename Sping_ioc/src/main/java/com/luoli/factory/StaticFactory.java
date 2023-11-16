package com.luoli.factory;


import com.luoli.dao.UserDao;
import com.luoli.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
