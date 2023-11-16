package com.luoli.service;

import com.luoli.pojo.Role;
import com.luoli.pojo.User;

import java.util.List;

public interface UserService {

    List<User> list();

    List<Role> save(User user, Long[] roleIds);

    void del(Long userId);

    User login(String username, String password);
}
