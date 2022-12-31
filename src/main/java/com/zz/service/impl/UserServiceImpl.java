package com.zz.service.impl;

import com.zz.dao.UserDao;
import com.zz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        userDao.addUser();
    }

    public UserServiceImpl() {
        System.out.println("userService的构造函数");
    }

}
