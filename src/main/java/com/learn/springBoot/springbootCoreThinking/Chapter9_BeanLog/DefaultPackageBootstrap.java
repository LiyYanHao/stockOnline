package com.learn.springBoot.springbootCoreThinking.Chapter9_BeanLog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/11
 * Time: 7:04
 * Description: No Description
 */
@ComponentScan(basePackageClasses = DefaultPackageBootstrap.class)
public class DefaultPackageBootstrap {
    public static void main(String[] args) {
        // 注册当前引导类作为配置 Class，并启动当前上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DefaultPackageBootstrap.class);
        // 输出当前 Spring 应用上下文中所有注册的 Bean 名称
        System.out.println("当前 Spring 应用上下文中所有注册的 Bean 名称：");
        Stream.of(context.getBeanDefinitionNames())
                .map(name -> "bean:\t"+name)
                .forEach(System.out::println);
    }
}
