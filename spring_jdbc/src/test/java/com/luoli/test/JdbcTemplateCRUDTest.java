package com.luoli.test;

import com.luoli.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    //更新操作
    public void  testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?",10000,"ls");

    }
    @Test
    //删除
    public void  testDelete(){
        jdbcTemplate.update("delete from account  where name=?","ls");

    }
    @Test
    //查询
    public void  testQueryOne(){
        Account account =jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "tom");

        System.out.println(account);

    }
    @Test
    //查询
    public void  testQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account ", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);

    }
    @Test
    //查询
    public void  testQueryCount(){
        Long count=jdbcTemplate.queryForObject("select count(*) from account ", Long.class);

        System.out.println(count);

    }
}
