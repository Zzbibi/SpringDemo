package com.example.demo1.springextension;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

/**
 * @Author zhangzhen
 * @create 2022/12/31 11:07
 */
public class HttpControllerFactoryBean implements FactoryBean<Object> {

    private String baseUrl;
    private Class<?> targetClazz;
    private Class<InvocationHandler> invocationHandlerClazz;

    @Override
    public Object getObject() throws Exception {
        InvocationHandler invocationHandler;
        try {
            invocationHandler = invocationHandlerClazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Create invocationHandler instance error! e={}", e.getCause());
        }
        return Proxy.newProxyInstance(HttpControllerFactoryBean.class.getClassLoader(),
                new Class[]{targetClazz}, invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return targetClazz;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
