package com.config;

import com.EnableAnnotation.EnableScheduling;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by lyh on 17-5-20.
 */
@Configuration
@EnableWebMvc//开启springmvc支持，若无次句，重写WebMvcConfigurerAdapter方法无效
@EnableScheduling//开启计划任务支持
@ComponentScan("com.stockonline.controller")
public class MyMvcConfig extends WebMvcConfigurerAdapter {//重写方法对springmvc配置
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new
                InternalResourceViewResolver();
        viewResolver.setPrefix("classpath:/static/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }




    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //addResourceHandler 暴露的路径  addResourceLocations放置文件的路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }




    //无业务功能的跳转 集中管理
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");//js的sse客户端实现服务端推送
        registry.addViewController("/async").setViewName("/async");//服务端定时任务推送
    }



    @Override//不忽略点
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
