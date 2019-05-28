package com.learn.springBoot.Implements.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Order 注解进行升序执行
 * @author lyh on 2019/5/21
 */
@Order(value=2)
@Component
public class ApplicationStartupRunnerOrderOne implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("ApplicationStartupRunner=ApplicationStartupRunner run method Started !!value=2");
    }
}
