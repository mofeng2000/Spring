package com.luoli.service;

import com.luoli.dao.UserMapper;
//import com.luoli.dao.impl.UserMapperImpl;
import com.luoli.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceTest {
    public static void main(String[] args) throws IOException {
//        UserMapper userMapper=new UserMapperImpl();
//        List<User> userList = userMapper.findAll();
//        System.out.println(userList);
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        System.out.println(all);
        User user = mapper.findById(1);
        System.out.println(user);

    }
}