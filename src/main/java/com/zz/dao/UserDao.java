package com.zz.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class UserDao implements BeanFactoryAware, InitializingBean, DisposableBean, BeanNameAware {

    private String userMapper;

    public UserDao() {
        System.out.println("UserDao的构造函数");
    }

    public void addUser() {
        System.out.println("add user...");
    }

    public void setUserMapper(String userMapper) {
        System.out.println("属性注入");
        this.userMapper = userMapper;
    }

    /**
     * 在 bean 初始化时调用
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        myInit();
        System.out.println("InitializingBean.afterPropertiesSet...");
    }

    /**
     * @PreDestory 注解之后调用
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        myDestroy();
        System.out.println("InitializingBean.destroy...");
    }

    public void  myInit() {
        System.out.println("userDao.myInit...");
    }

    public void myDestroy() {
        System.out.println("userDao.myDestroy...");
    }

    /**
     * 在 bean 初始化时调用，在 afterPropertiesSet 之后调用
     */
    @PostConstruct
    public void PostConstruct() {
        System.out.println("userDao.PostConstruct...");
    }

    /**
     * 在 spring 上下文销毁之后调用，即 smartLifeCycle.stop 之后调用
     */
    @PreDestroy
    public void mPreDestroy() {
        System.out.println("userDao.mPreDestroy...");
    }

    // BeanFactoryAware的方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware.setBeanFactory...");
    }

    // BeanNameAware的方法
    @Override
    public void setBeanName(String beanName) {
        System.out.println("BeanNameAware.setBeanName...");
    }

}
