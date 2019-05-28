package com.learn.springBoot.Implements.AutoConfigureDemo;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author lyh on 2019/5/21
 */
@Configuration
public class DemoAutoConfigureAfterTest {
    @Bean
    public Integer pringStrTest(){
            System.out.println("+++++++DemoAutoConfigureAfterTest+++++++");
        return 1;
    }
}
