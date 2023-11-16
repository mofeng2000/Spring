package com.luoli.factory;

import com.luoli.dao.UserDao;
import com.luoli.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public  UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
