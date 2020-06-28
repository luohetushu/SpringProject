package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器：用于处理用户请求，并封装响应到视图的数据
 * 使用注解方式：自定义处理用户请求并封装响应数据的方法
 * todo 该控制器是单例模式，在服务器启动时创建对象
 * 通过设置请求方法来调用对应的方法
 */
@Controller
@RequestMapping(value = "/method.form")
public class MethodController {

    /**
     * 用于处理用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/method.form?method=add 该地址时，才会调用该方法
     * @return
     */
    @RequestMapping(params = "method=add")
    public String add(){
        return "redirect:/index.jsp"; // todo 与 [dispatcher]-servlet.xml 配置文件中是否配置视图渲染器无关
    }

    /**
     * 用于处理用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/method.form?method=update 该地址时，且使用 post 请求方式，才能正确调用该方法
     * @return
     */
    @RequestMapping(params = "method=update", method = RequestMethod.POST)
    public String update(){
        return "redirect:/index.jsp"; // todo 与 [dispatcher]-servlet.xml 配置文件中是否配置视图渲染器无关
    }

}
