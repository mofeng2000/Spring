package com.luoli.mapper;

import com.luoli.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface Mapper {
    //@Insert("insert  into account values(null,#{name},#{money})")
    void add(Account account);

    //@Select("select * from account")
    List<Account> selectAll();
}
