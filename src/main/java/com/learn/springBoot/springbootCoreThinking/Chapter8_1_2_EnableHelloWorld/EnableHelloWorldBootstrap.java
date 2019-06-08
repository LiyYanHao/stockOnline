package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_EnableHelloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh on 2019/6/8
 */
@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootstrap {
    public static void main(String[] args){
        //构建Annotation配置驱动spring上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        //注册当前引导类
        context.register(HelloWorldConfiguration.class);
        context.refresh();
        //获取名称helloworld的bean对象
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld="+helloWorld);
        context.close();
    }
}
