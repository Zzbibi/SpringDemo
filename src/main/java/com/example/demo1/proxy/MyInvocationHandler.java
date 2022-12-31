package com.example.demo1.proxy;

import com.example.demo1.annotation.HttpMethod;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @Author zhangzhen
 * @create 2022/12/31 16:29
 */
public class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HttpMethod httpMethod = method.getAnnotation(HttpMethod.class);

        return null;
    }

}
