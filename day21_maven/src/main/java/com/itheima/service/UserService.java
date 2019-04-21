package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.util.List;

/**
 * UserService
 *
 * @author Huang
 * @date 2019/2/25 19:41
 */
public class UserService {
    UserDao userDao = new UserDao();

    public List<User> findAll() {
        return userDao.findAll();
    }

    public int add(User user) {
        return userDao.add(user);
    }
}
