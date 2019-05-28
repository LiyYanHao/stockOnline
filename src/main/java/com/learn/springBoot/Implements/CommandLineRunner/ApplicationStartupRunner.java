package com.learn.springBoot.Implements.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author lyh on 2019/5/21
 */
@Component
public class ApplicationStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("ApplicationStartupRunner=ApplicationStartupRunner run method Started !!");
    }
}
