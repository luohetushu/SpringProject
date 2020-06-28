package com.spring.mvc.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 自定义公共处理类，使用注解的方式
 * 缓存模块
 */
@Aspect
public class CacheProxy {

    /**
     * 在真实业务类方法调用之前执行
     */
    @Before("execution(* com.spring.mvc.impel.*.*(..))")
    public void before(){
        System.out.println("在真实业务类方法调用之前执行，开始缓存的配置");
    }

    /**
     * 在真实业务类方法正常结束之后执行
     */
    @After("execution(* com.spring.mvc.impel.*.*(..))")
    public void after(){
        System.out.println("在真实业务类方法正常结束之后执行，进行缓存的清理");
    }

    /**
     * 环绕通知
     * @param pjp
     */
    @Around("execution(* com.spring.mvc.impel.*.*(..))")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("环绕前，之后前置通知方法 before 执行");
        Object proceed = null;
        Object[] args = pjp.getArgs();
        try {
            proceed = pjp.proceed(args);  //执行真实业务类方法
            System.out.println("环绕后，真实业务类方法正常结束，之后后置通知方法 after 执行");
            return proceed;
        } catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("异常通知方法执行");
        } finally {
            System.out.println("最终通知方法执行");
        }
        return proceed;
    }


}
