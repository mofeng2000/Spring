package com.luoli.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luoli.mapper.OrderMapper;
import com.luoli.mapper.UserMapper;
import com.luoli.pojo.Order;
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
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
//        List<Order> orderList = mapper.selectAll();
//        for (Order order : orderList) {
//            System.out.println(order);
//        }
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

}