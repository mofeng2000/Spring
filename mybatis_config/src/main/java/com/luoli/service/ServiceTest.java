package com.luoli.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luoli.mapper.UserMapper;
import com.luoli.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ServiceTest {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      //  User user=new User();
//
//        user.setUsername("ceshi");
//        user.setPassword("abc");
//        user.setBirthday(new Date());

       // mapper.save(user);

        //设置分页相关参数 当前页+每一页显示的条数
        PageHelper.startPage(2,3);
        List<User> userList = mapper.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获取与分页相关的参数
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("每一页显示数"+pageInfo.getPageNum());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("是否是第一页"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页"+pageInfo.isIsLastPage());
        //System.out.println(userList);


    }
}