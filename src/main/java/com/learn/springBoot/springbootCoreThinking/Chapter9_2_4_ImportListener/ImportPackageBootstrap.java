package com.learn.springBoot.springbootCoreThinking.Chapter9_2_4_ImportListener;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/11
 * Time: 7:04
 * Description: No Description
 */
@EnableAutoConfiguration(exclude = SpringApplicationAdminJmxAutoConfiguration.class)
public class ImportPackageBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ImportPackageBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args)
                .close();
    }
}
