package com.example.demo1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zhangzhen
 * @create 2022/12/31 10:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HttpController {

    /**
     * 请求域名
     *
     * @return
     */
    String baseUrl() default "";

    /**
     * 代理类 clazz
     *
     * @return
     */
    Class<?> invocationHandlerClass();

}
