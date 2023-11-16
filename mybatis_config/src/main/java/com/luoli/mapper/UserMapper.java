package com.luoli.mapper;

import com.luoli.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public void save(User user);
    public User selectById(@Param("id") int id);
    public List<User> selectAll();

}
