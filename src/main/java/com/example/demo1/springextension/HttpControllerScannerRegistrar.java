package com.example.demo1.springextension;

import com.example.demo1.annotation.HttpController;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @Author zhangzhen
 * @create 2022/12/31 11:23
 */
public class HttpControllerScannerRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 生成 HttpControllerFactoryBean 的 beanDefinition，并注入到 spring 容器
     *
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ClassPathScanningCandidateComponentProvider scanner = newScanner(HttpController.class.getName());
        // 指定扫描的包路径
        Set<BeanDefinition> beanDefinitionSet = scanner.findCandidateComponents("com.example.demo1.biz.service");
        for (BeanDefinition beanDefinition : beanDefinitionSet) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                registerBeanDefinition((AnnotatedBeanDefinition) beanDefinition, registry, HttpController.class.getName());
            }
        }
    }

    private void registerBeanDefinition(AnnotatedBeanDefinition beanDefinition, BeanDefinitionRegistry registry, String annotationName) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        String targetClazzName = metadata.getClassName();

        // 生成BeanDefinition
        AbstractBeanDefinition factoryBeanBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(
                HttpControllerFactoryBean.class).getBeanDefinition();
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                metadata.getAnnotationAttributes(annotationName));
        MutablePropertyValues propertyValues = factoryBeanBeanDefinition.getPropertyValues();
        propertyValues.add("baseUrl", annotationAttributes.getString("baseUrl"));
        propertyValues.add("targetClazz", targetClazzName);
        propertyValues.add("invocationHandlerClazz", annotationAttributes.get("invocationHandlerClass"));

        registry.registerBeanDefinition(targetClazzName, factoryBeanBeanDefinition);
    }

    private ClassPathScanningCandidateComponentProvider newScanner(final String annotationName) {
        // 只扫描 annotationName 注解
        return new ClassPathScanningCandidateComponentProvider(false) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                if (beanDefinition.getMetadata().isInterface()) {
                    return beanDefinition.getMetadata().hasAnnotatedMethods(annotationName);
                }
                return false;
            }
        };
    }

}
