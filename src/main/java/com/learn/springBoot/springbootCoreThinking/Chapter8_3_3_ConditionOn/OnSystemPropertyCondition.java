package com.learn.springBoot.springbootCoreThinking.Chapter8_3_3_ConditionOn;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/10
 * Time: 20:20
 * Description: 指定系统属性名称与值匹配条件
 */
public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取 ConditionalOnSystemProperty 所有的属性方法值
        MultiValueMap<String, Object> allAnnotationAttributes =
                metadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        // 获取 ConditionalOnSystemProperty#name() 方法值（单值）
        String name = (String)allAnnotationAttributes.getFirst("name");
        // 获取 ConditionalOnSystemProperty#value() 方法值（单值）
        String value = (String)allAnnotationAttributes.getFirst("value");
        // 获取 系统属性值
        String systemPropertyValue = System.getProperty(name);
        // 比较 系统属性值 与 ConditionalOnSystemProperty#value() 方法值 是否相等
        if(Objects.equals(systemPropertyValue,value)){
            System.out.printf("系统属性[名称 : %s] 找到匹配值 : %s\n",systemPropertyValue,value);
            return true;
        }
        return false;
    }
}
