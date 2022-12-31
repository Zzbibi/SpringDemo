package com.zz.config;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("BeanPostProcessor的构造函数");
    }

    /**
     * bean初始化之前调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userDao".equals(beanName)) {
            System.out.println("beanPostProcessor.postProcessBeforeInitialization...");
        }
        return bean;
    }

    /**
     * bean初始化之后调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("userDao".equals(beanName)) {
            System.out.println("beanPostProcessor.postProcessAfterInitialization...");
        }
        return bean;
    }

}
