package com.example.demo1.biz.service;

import com.example.demo1.annotation.HttpController;
import com.example.demo1.proxy.MyInvocationHandler;

/**
 * @Author zhangzhen
 * @create 2022/12/31 11:55
 */
@HttpController(baseUrl = "http://localhost:8080/test", invocationHandlerClass = MyInvocationHandler.class)
public interface HelloService {

    void hello();

}
