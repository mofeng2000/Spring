package com.luoli.dao;

import com.luoli.pojo.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleById(Long id);
}
