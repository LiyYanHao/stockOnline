package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_ImportSelectorServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh on 2019/6/8
 */
@Configuration
@EnableServer(type = Server.Type.FTP)//切换位FTP服务器
public class EnableServerBootStrap {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.register(EnableServerBootStrap.class);
        context.refresh();
        Server bean = context.getBean(Server.class);
        bean.start();
        bean.stop();
    }
}
