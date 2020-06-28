package com.spring.mvc.proxy;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.aop.*;

import java.lang.reflect.Method;

/**
 * 公共业务类，即切面，关注点模块
 * 记录模块
 * 需要实现不同的通知类型，根据不同的通知类型来实现公共业务类方法在真实业务方法调用前后或者抛出异常时执行
 *     通知类型：前置通知：org.springframework.aop.MethodBeforeAdvice
 *                          public interface MethodBeforeAdvice extends BeforeAdvice {
 *                              void before(Method var1, Object[] var2, @Nullable Object var3) throws Throwable; }
 *              后置通知：org.springframework.aop.AfterReturningAdvice
 *                          public interface AfterReturningAdvice extends AfterAdvice {void afterReturning(@Nullable Object var1,
 *                          Method var2, Object[] var3, @Nullable Object var4) throws Throwable;}
 *              异常通知：
 *              最终通知：
 *              环绕通知：
 */
public class Logging implements MethodBeforeAdvice, AfterReturningAdvice {

    /**
     * 在真实业务类方法调用之前执行
     * @param method 真实业务类方法
     * @param args 真实业务类方法参数
     * @param target  真实业务类对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("代理 " + target.getClass().getSimpleName()
                + " 开始了：在目标方法 " + method.getName()
                + " 之前执行，该方法有 " + args.length + " 个参数");
    }


    /**
     * 在真实业务类方法正常结束之后执行
     * @param returnValue  真实业务类方法返回的数据
     * @param method  真实业务类方法
     * @param args   真实业务类方法参数
     * @param target 真实业务类对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("代理 " + target.getClass().getSimpleName()
                + " 结束了：在目标方法 " + method.getName()
                + " 正常结束后执行，该方法有 " + args.length + " 个参数，返回值是 " + returnValue);
    }
}
