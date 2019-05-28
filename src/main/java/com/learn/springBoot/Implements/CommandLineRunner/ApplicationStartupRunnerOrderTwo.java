package com.learn.springBoot.Implements.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lyh on 2019/5/21
 */
@Order(value=3)
@Component
public class ApplicationStartupRunnerOrderTwo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("ApplicationStartupRunner=ApplicationStartupRunner run method Started !!value=3");
    }
}
