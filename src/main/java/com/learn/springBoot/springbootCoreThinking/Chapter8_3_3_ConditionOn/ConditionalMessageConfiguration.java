package com.learn.springBoot.springbootCoreThinking.Chapter8_3_3_ConditionOn;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/10
 * Time: 20:25
 * Description: 条件消息配置
 */
@Configuration
public class ConditionalMessageConfiguration {

    @ConditionalOnSystemProperty(name = "language",value = "Chinese")
    @Bean("message")
    public String chineseMessage(){
        return "你好，世界";
    }


    @ConditionalOnSystemProperty(name = "language",value = "English")
    @Bean("message")
    public String englishMessage(){
        return "Hello,World";
    }
}
