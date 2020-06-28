package com.spring.mvc.proxy;

/**
 * 自定义公共处理类
 * 安全模块
 */
public class Security {

    /**
     * 在真实业务类方法调用之前执行
     */
    public void before(){
        System.out.println("在真实业务类方法调用之前执行");
    }

    /**
     * 在真实业务类方法正常结束之后执行
     */
    public void after(){
        System.out.println("在真实业务类方法正常结束之后执行");
    }

}
