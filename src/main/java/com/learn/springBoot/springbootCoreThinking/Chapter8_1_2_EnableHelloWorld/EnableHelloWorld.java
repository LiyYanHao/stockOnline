package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_EnableHelloWorld;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 实心Enable驱动
 * @author lyh on 2019/6/8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
