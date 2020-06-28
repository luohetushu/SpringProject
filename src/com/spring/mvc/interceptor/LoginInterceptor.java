package com.spring.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 指定拦截器，拦截指定请求地址的拦截器
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //注入参数 在配置文件中使用 依赖注入 注入值
    private List<String>  allowedPass;

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

        //获取会话域中存储的内容
        Object heiseiRider = request.getSession().getAttribute("drive");
        if (heiseiRider != null){
            return true;
        }

        //获取请求地址
        String url = request.getRequestURL().toString();
        for (String suffix : allowedPass) {
            if (url.endsWith(suffix)){
                return true;
            }
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return false;
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

    public void setAllowedPass(List<String> allowedPass) {
        this.allowedPass = allowedPass;
    }
}
