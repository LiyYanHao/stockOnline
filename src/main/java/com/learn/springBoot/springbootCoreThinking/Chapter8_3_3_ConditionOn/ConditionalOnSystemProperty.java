package com.learn.springBoot.springbootCoreThinking.Chapter8_3_3_ConditionOn;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/10
 * Time: 20:34
 * Description: 自定义条件注解
 */
@Target({ElementType.METHOD}) // 只能标注在方法上面
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    String name();
    String value();

}
