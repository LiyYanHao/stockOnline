package com.learn.springBoot.Implements;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *ApplicationContextInitializer是在springboot启动过程(refresh方法前)调用
 * @author lyh on 2019/5/21
 */
public class DemoApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("user add method ==> ApplicationContextInitializer");
    }
}

