package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_EnableHelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh on 2019/6/8
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "hello World";
    }
}
