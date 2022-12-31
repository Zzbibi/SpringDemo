package com.zz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration
//@ComponentScan(basePackages = "com.zz")
//@Import(MyImportBeanDefinitionRegistrar.class)
public class ContextConfig {

//    @Bean
//    public UserDaoFactory userFactoryBean() {
//        return new UserDaoFactory();
//    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor() {
        return new MyInstantiationAwareBeanPostProcessor();
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    @Bean
    public MySmartLifeCycle mySmartLifeCycle() {
        return new MySmartLifeCycle();
    }

    @Bean
    public MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor() {
        return new MyBeanDefinitionRegistryPostProcessor();
    }

    @Bean
    public MyMergedBeanDefinitionPostProcessor myMergedBeanDefinitionPostProcessor() {
        return new MyMergedBeanDefinitionPostProcessor();
    }

}
