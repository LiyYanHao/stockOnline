package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_ImportSelectorServer;

/**
 * @author lyh on 2019/6/8
 */
public interface Server {

    void start();

    void stop();


    enum Type {
        HTTP,
        FTP
    }
}
