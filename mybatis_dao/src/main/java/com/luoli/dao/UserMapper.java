package com.luoli.dao;

import com.luoli.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll();
     public User findById(int id);
}
