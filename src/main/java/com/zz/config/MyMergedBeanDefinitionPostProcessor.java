package com.zz.config;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @Author zhangzhen
 * @create 2022/12/18 16:14
 */
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

    public MyMergedBeanDefinitionPostProcessor() {
        System.out.println("MergedBeanDefinitionPostProcessor的构造函数");
    }

    /**
     * 在 bean 实例化之后，属性赋值之前调用
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if ("userDao".equals(beanName)) {
            System.out.println("MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition...");
        }
    }

}
