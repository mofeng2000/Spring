package com.luoli.dao;

import com.luoli.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void del(Long userId);

    void delUserRoleRel(Long userId);

    User findByUsernameAndPassword(String username, String password) throws Exception;
}
