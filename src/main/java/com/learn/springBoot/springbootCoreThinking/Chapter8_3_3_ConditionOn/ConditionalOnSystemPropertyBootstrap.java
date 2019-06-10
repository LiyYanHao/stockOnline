package com.learn.springBoot.springbootCoreThinking.Chapter8_3_3_ConditionOn;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/10
 * Time: 20:29
 * Description: No Description
 */
public class ConditionalOnSystemPropertyBootstrap {

    public static void main(String[]args){
        // 设置 System Property  language = Chinese
        System.setProperty("language", "Chinese");
        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 配置Bean ConditionalMessageConfiguration 到 Spring 上下文
        context.register(ConditionalMessageConfiguration.class);
        // 启动上下文
        context.refresh();
        // 获取名称为 "message" Bean 对象
        String message = context.getBean("message", String.class);
        // 输出 message 内容
        System.out.printf("\"message\" Bean 对象 : %s\n", message);

        context.close();
    }
}
