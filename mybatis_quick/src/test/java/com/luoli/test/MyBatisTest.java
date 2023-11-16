package com.luoli.test;

import com.luoli.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void test1() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();

    }
    @Test
    public void test2() throws IOException {
        //模拟对象
        User user=new User();
        user.setUsername("tom");
        user.setPassword("123");

        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数：namespace+id
         sqlSession.insert("userMapper.save",user);

        //释放资源
        sqlSession.close();

    }
    @Test
    public void test3() throws IOException {
        //模拟对象
        User user=new User();
        user.setId(2);
        user.setUsername("zhangsan2");
        user.setPassword("123");

        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数：namespace+id
        sqlSession.update("userMapper.update",user);

        //释放资源
        sqlSession.close();

    }
    @Test
    public void test4() throws IOException {
        //模拟对象
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作 参数：namespace+id
        sqlSession.update("userMapper.delete",4);

        //释放资源
        sqlSession.close();

    }
}
