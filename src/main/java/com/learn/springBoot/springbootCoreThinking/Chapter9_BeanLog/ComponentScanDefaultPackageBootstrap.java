package com.learn.springBoot.springbootCoreThinking.Chapter9_BeanLog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/11
 * Time: 6:56
 * Description: ComponentScan 默认包引导类 打印所有的bean
 */
@ComponentScan(basePackages = "")
public class ComponentScanDefaultPackageBootstrap {
    public static void main(String[] args) {
        // 注册当前引导类作为配置 Class，并启动当前上下文
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(ComponentScanDefaultPackageBootstrap.class);
        // 输出当前 Spring 应用上下文中所有注册的 Bean 名称
        System.out.println("当前 Spring 应用上下文中所有注册的 Bean 名称：");
        Stream.of(annotationConfigApplicationContext.getBeanDefinitionNames())
                .map(name -> "\t"+name)
                .forEach(System.out::println);
        annotationConfigApplicationContext.close();
    }
}
