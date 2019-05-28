package com.learn.springBoot.Implements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 在springboot启动的时候做一些自定义的操作
 * @author lyh on 2019/5/21
 */
public class DemoSpringApplicationRunListener implements SpringApplicationRunListener {

    /**
     * 重写构造方法
     * @param application
     * @param args
     */
    public DemoSpringApplicationRunListener(SpringApplication application, String[]  args){
        System.out.println("constructor");
    }
    @Override
    public void starting() {
        System.out.println("starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded");
    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("running");
    }


}
