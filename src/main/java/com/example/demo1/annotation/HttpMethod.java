package com.example.demo1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zhangzhen
 * @create 2022/12/31 10:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HttpMethod {

    /**
     * 请求url
     *
     * @return
     */
    String url();

    /**
     * 请求method
     *
     * @return
     */
    HttpRequestMethod requestMethod() default HttpRequestMethod.GET;

    enum HttpRequestMethod {
        GET,
        POST
    }

}
