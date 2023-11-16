package com.luoli.service.impl;

import com.luoli.mapper.Mapper;
import com.luoli.pojo.Account;
import com.luoli.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//标识为accountService类，让spring容器管理
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private Mapper mapper;

    public void add(Account account) {
        mapper.add(account);

    }

    public List<Account> selectAll() {

        return mapper.selectAll();

    }
}
