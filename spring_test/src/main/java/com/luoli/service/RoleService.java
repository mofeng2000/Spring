package com.luoli.service;

import com.luoli.pojo.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
