package com.spring.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 公共拦截器，拦截所有的请求，可以配置多个
 */
public class BaseInterceptor implements HandlerInterceptor {

    /**
     * 在 DispatcherServlet 的控制器中的处理请求方法之前执行
     * @param request
     * @param response
     * @param handler
     * @return  如果返回为 true，则执行之后的处理方法与之后的拦截器；返回 false，则不执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 在 DispatcherServlet 的控制器中的处理请求方法之后，渲染视图之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView  封装响应到视图的数据
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在页面渲染完成返回给客户端之前执行 进行清理等收尾工作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
