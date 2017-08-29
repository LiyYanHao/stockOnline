package com.EnableAnnotation;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;

import java.lang.annotation.*;

/**
 * Created by lyh on 17-5-19.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AsyncConfigurationSelector.class)//AsyncConfigurationSelector通过条件来选择需要导入的配置类，
//AsyncConfigurationSelector的根接口为ImportSeletor,这个接口重写SelectImports方法,在此方法中进行条件判断
//在此方法内先进行事先的条件判断，此列中，若adviceMode为PORXY则返回PoxyAsyncCondfiguation这个配置类，z
//若activeMode为ASPECTJ，则返回PoxyAsyncCondfiguation配置类
public @interface EnableAsync {
    Class<? extends Annotation> annotation()default Annotation.class;
    boolean poxyTargetClass()default false;
    AdviceMode mode()default AdviceMode.PROXY;
    int order()default Ordered.LOWEST_PRECEDENCE;
}
