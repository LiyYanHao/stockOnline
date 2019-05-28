package com.learn.springBoot.Implements.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.assertj.core.condition.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Aop日志控制
 *
 * @author lyh on 2019/5/22
 */
@Aspect
@Component
public class WebControllerLogAop {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 指定切点
     * 匹配 com.stockonline.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(public * com.stockonline.controller.*.*(..))")
    public void webLog() {
        logger.info("进入切点");
    }

    /**
     * 前置通知，方法调用前被调用
     *
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("我是前置通知!!!\"");
        //获取目标方法的参数信息
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        logger.info("方法：" + signature.getName());
        //AOP代理类的名字
        logger.info("方法所在包:" + signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        Class declaringType = signature.getDeclaringType();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        System.out.println("参数名：" + Arrays.toString(parameterNames));
        System.out.println("参数值ARGS : " + Arrays.toString(joinPoint.getArgs()));
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        // 记录下请求内容
        logger.info("请求URL : " + req.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + req.getMethod());
        logger.info("IP : " + req.getRemoteAddr());
        logger.info("CLASS_METHOD : " +
                joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
    }

    /**
     * 处理完请求返回内容
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret)throws Throwable{
        // 处理完请求，返回内容
        logger.info("方法的返回值 :"+ret);
    }

    /**
     * 后置异常通知
     * @param joinPoint
     */
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint joinPoint){
        logger.info("方法异常时执行....");
    }
    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param joinPoint
     */
    @After("webLog()")
    public void after(JoinPoint joinPoint){

    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     *
     * @param pjp
     * @return
     */
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp){
        try{
            Object proceed = pjp.proceed();
            return proceed;
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }


}
