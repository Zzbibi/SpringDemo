package com.zz.config;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * 用于获取 ResourceLoader， 加载外部资源
 *
 * @Author zhangzhen
 * @create 2022/12/18 15:58
 */
public class MyResourceLoaderAware implements ResourceLoaderAware {

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

}
