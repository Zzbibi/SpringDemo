package com.zz.controller;

import com.zz.config.ContextConfig;
import com.zz.dao.UserDao;
import com.zz.service.impl.HelloServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
//        UserService userService = context.getBean("userService", UserService.class);
//        userService.add();
        UserDao userDao = context.getBean("userDao", UserDao.class);
        //userDao.addUser();

//        HelloServiceImpl helloService = context.getBean("helloServiceImpl", HelloServiceImpl.class);
//        System.out.println(helloService);
        context.destroy();
    }

}
