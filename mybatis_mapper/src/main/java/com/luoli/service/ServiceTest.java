package com.luoli.service;

import com.luoli.mapper.UserMapper;
import com.luoli.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ServiceTest {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       // User condition=new User();
       // condition.setId(1);
        //condition.setUsername("zhangsan");
        //condition.setPassword("123");

       // List<User>userList= mapper.findByCondition(condition);
      List<Integer> ids=new ArrayList<Integer>();
//      ids.add(1);
//      ids.add(2);
//      ids.add(3);
        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);

    }
}