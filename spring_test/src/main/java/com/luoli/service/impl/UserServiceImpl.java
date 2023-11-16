package com.luoli.service.impl;

import com.luoli.dao.RoleDao;
import com.luoli.dao.UserDao;
import com.luoli.pojo.Role;
import com.luoli.pojo.User;
import com.luoli.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    /**
     * 查询用户信息
     * @return
     */
    public List<User> list(){
            List<User> userList=userDao.findAll();
            //封装 userList中的每一个User的roles数据
        for (User user : userList) {
            //获取user id
            Long id=user.getId();
            //将id作为参数，查询当前userId对应的role集合数据
            List <Role> roles=roleDao.findRoleById(id);
            user.setRoles(roles);

        }
            return userList;
    }

    public List<Role> save(User user, Long[] roleIds) {
        //1.向sys_user 表中存储数据
        Long userId = userDao.save(user);
        //2.向sys_uer_role关系表存储多条数据
            userDao.saveUserRoleRel(userId,roleIds);
        return null;
    }

    public void del(Long userId) {
        //删除 sys_user_role 关系表
        userDao.delUserRoleRel(userId);
        //删除sys_user表
        userDao.del(userId);
    }

    public User login(String username, String password) {

        try {
            User  user = userDao.findByUsernameAndPassword(username,password);
            return user;
        } catch (Exception e) {

            return null;
        }

    }
}
