package com.luoli.mapper;

import com.luoli.pojo.Order;
import com.luoli.pojo.User;

import java.util.List;

public interface UserMapper {
     List<User> selectAll();
     List<User> selectUserAndRole();

}
