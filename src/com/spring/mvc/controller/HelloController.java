package com.spring.mvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制器：用于处理用户请求，并封装响应到视图的数据
 * 使用实现接口的方式
 */
public class HelloController implements Controller {

    /**
     * 用于处理用户请求，并封装响应到视图的数据
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mav = new ModelAndView();
        //封装要显示到视图的数据
        mav.addObject("hello", "Hello SpringMVC!"); //在请求域（requestScope）中存储属性
        //设置视图名
        mav.setViewName("hello");  // 在 servlet 分发器配置文件中配置视图的路径(/WEB-INF/jsp)与后缀(.jsp)，
                                   // 最后 view 视图为 /WEB-INF/jsp/hello.jsp



        return mav;
    }
}
