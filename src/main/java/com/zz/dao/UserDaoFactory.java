package com.zz.dao;

import org.springframework.beans.factory.FactoryBean;

public class UserDaoFactory implements FactoryBean<UserDao> {

    public UserDaoFactory() {
        System.out.println("UserFactoryBean instantiating...");
    }

    @Override
    public UserDao getObject() {
        System.out.println("userFactoryBean.getObject...");
        return new UserDao();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
