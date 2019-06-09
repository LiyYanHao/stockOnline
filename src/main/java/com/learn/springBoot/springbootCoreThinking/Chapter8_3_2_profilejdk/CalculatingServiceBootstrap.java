package com.learn.springBoot.springbootCoreThinking.Chapter8_3_2_profilejdk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/9
 * Time: 18:54
 * Description: No Description
 */
@Configuration
@ComponentScan(basePackageClasses = CalculatingService.class)//扫描注解service
public class CalculatingServiceBootstrap {

    static {
        // 通过 Java 系统属性设置 Spring Profile
        // 以下语句等效于 ConfigurableEnvironment.setActiveProfiles("Java8")
        //System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "Java8");
        // 以下语句等效于 ConfigurableEnvironment.setDefaultProfiles("Java7")
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "Java7");
    }

    public static void main(String[] args){
        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 当前配置Bean 到 Spring 上下文
        context.register(CalculatingServiceBootstrap.class);
        // 启动上下文
        context.refresh();
        // 获取 CalculatingService Bean
        CalculatingService bean = context.getBean(CalculatingService.class);
        bean.sum(1,2,3,4,5,6,7,8);
        context.close();
    }
}





















