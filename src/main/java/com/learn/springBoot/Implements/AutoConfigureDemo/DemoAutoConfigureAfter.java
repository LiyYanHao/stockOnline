package com.learn.springBoot.Implements.AutoConfigureDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;

/**
 * 在某个指定的配置类执行后执行
 * @author lyh on 2019/5/21
 */
@AutoConfigureAfter(DemoAutoConfigureAfterTest.class)
public class DemoAutoConfigureAfter {
    @Bean
    public Integer pringStr(){
        System.out.println("+++++++DemoAutoConfigureAfter+++++++");
        return 1;
    }


}
