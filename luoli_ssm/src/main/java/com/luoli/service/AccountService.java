package com.luoli.service;

import com.luoli.pojo.Account;

import java.util.List;

public interface AccountService {
    void add(Account account);

    List<Account> selectAll();
}
