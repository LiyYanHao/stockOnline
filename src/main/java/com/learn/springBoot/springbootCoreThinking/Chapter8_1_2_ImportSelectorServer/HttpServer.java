package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_ImportSelectorServer;

import org.springframework.stereotype.Component;

/**
 * @author lyh on 2019/6/8
 */
@Component
public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("httpServer服务启动中");
    }

    @Override
    public void stop() {
        System.out.println("httpServer服务停止中");
    }

}

