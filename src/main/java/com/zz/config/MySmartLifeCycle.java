package com.zz.config;

import org.springframework.context.SmartLifecycle;

public class MySmartLifeCycle implements SmartLifecycle {

    private boolean isRunning = false;

    /**
     * 所有的bean都创建成功之后调用，即 postProcessAfterInitialization 之后调用
     */
    @Override
    public void start() {
        System.out.println("SmartLifecycle.start...");
        isRunning = true;
    }

    /**
     * Spring上下文销毁时调用
     */
    @Override
    public void stop() {
        System.out.println("SmartLifecycle.stop...");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

}
