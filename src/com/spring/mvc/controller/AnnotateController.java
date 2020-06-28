package com.spring.mvc.controller;

import com.spring.mvc.beans.HeiseiRider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 控制器：用于处理用户请求，并封装响应到视图的数据
 * 使用注解方式：自定义处理用户请求并封装响应数据的方法
 * todo 该控制器是单例模式，在服务器启动时创建对象
 */
@Controller
public class AnnotateController {

    /**
     * 响应结果跳转方式：
     * 1、设置返回值 ModelAndView，根据 ModelAndView 的 viewName 与 [dispatcher]-servlet.xml 配置文件中视图渲染器的前缀和后缀名
     *    转发 到指定页面
     *    页面 url 地址为：视图渲染器的前缀名 + ModelAndView 的 viewName + 视图渲染器的后缀名
     * 2、不设置任何返回值，在处理方法中自定义跳转的页面
     * 3、设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     */

    /**
     * 用于处理用户请求，并封装响应到视图的数据
     * 只有在用户请求 /SpringMVC/hello.form 该地址时，才会调用该方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/annotate.form"})
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        Method handleMethod = AnnotateController.class.getDeclaredMethod("handleRequest",
                HttpServletRequest.class, HttpServletResponse.class);
        RequestMapping rm = handleMethod.getAnnotation(RequestMapping.class);
        System.out.println("name: " + rm.name());
        System.out.println("path-length: " + rm.path().length);
        System.out.println("path: " + (rm.path().length > 0 ? rm.path()[0] : ""));
        System.out.println("value-length: " + rm.value().length);  //value-length: 1
        System.out.println("value: " + (rm.value().length > 0 ? rm.value()[0] : "")); //value: /annotate.form

        ModelAndView mav = new ModelAndView();
        //封装要显示到视图的数据
        //在请求域（requestScope）中存储属性 相当于 httpServletRequest.setAttribute("annotate", "Hello Annotation SpringMVC!!!");
        mav.addObject("annotate", "Hello Annotation SpringMVC!!!");
        //设置视图名
        mav.setViewName("annotate");  // 在 servlet 分发器配置文件中配置视图的路径(/WEB-INF/jsp)与后缀(.jsp)，
        // 最后 view 视图为 /WEB-INF/jsp/hello.jsp


        return mav;
    }

    /**
     * 用于处理用户请求，并封装响应到视图的数据
     * 不设置任何返回值，在处理方法中自定义跳转的页面
     * 只有在用户请求 /SpringMVC/forward.form 该地址时，才会调用该方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping(value = "/forward.form")
    public void forwardPage(HttpServletRequest httpServletRequest,
                            HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("POST")){
            //设置请求编码
            httpServletRequest.setCharacterEncoding("UTF-8");
        }
        //设置响应编码
        httpServletResponse.setContentType("text/html; charset=utf-8");

        //在当前页面显示
        //httpServletResponse.getWriter().print("自定义跳转页面");

        //重定向
        //httpServletResponse.sendRedirect("index.jsp");

        //传递转发参数
        httpServletRequest.setAttribute("annotate", "Hello Forward Annotation SpringMVC!!!");
        //转发
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/annotate.jsp").forward(httpServletRequest, httpServletResponse);

    }

    /**
     * 用于处理用户请求，并封装响应到视图的数据
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/forwardPage.form 该地址时，才会调用该方法
     * @param map 用来封装响应到视图的数据，todo ModelMap 只能作为处理方法的参数，而不能在方法体中定义
     */
    @RequestMapping(value = "/forwardPage.form")
    public String forwardPage(ModelMap map){
        //封装要显示到视图的数据
        //在请求域（requestScope）中存储属性 相当于 httpServletRequest.setAttribute("attr", "ModelMap 对象封装响应到视图的数据");
        map.addAttribute("attr", "ModelMap 对象封装响应到视图的数据");
        return "/index.jsp";  // todo  要求 [dispatcher]-servlet.xml 配置文件中没有配置视图渲染器
    }

    /**
     * 用于处理带参数的用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/param.form?paramName=Drive
     * @param request SpringMVC 框架自动注入的参数，用来获取参数、传递参数、设置请求编码等
     * @param paramName 处理请求的方法参数，与请求地址的参数名一致才可用来获取参数值
     * @return
     */
    @RequestMapping("/param.form")
    public String handleParams(HttpServletRequest request, String paramName){
        String name = request.getParameter("paramName");
        System.out.println(name);
        request.setAttribute("hello", paramName);
        return "hello";  //要求 [dispatcher]-servlet.xml 配置文件中有配置视图渲染器
    }

    /**
     * 用于处理带参数的用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/annotate-param.form?paramName=Drive
     * @param name 处理请求的方法参数，用来获取请求地址的参数值，todo 需要进行参数注解，注解值与请求地址的参数名一致
     * @return
     */
    @RequestMapping("/annotate-param.form")
    public String handleParams(@RequestParam("paramName") String name){
        System.out.println(name);
        return "hello";  //todo 要求 [dispatcher]-servlet.xml 配置文件中有配置视图渲染器
    }

    /**
     * 用于处理带参数的用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/object-param.form?maleOwner=泊进之介&femaleOwner=诗岛雾子
     * @param rider 处理请求的方法的对象参数，用来获取请求地址的参数值，todo 请求地址的参数名与对象的成员属性名一致
     * @return
     */
    @RequestMapping("/object-param.form")
    public String handleParams(HeiseiRider rider){
        rider.love();
        return "hello";  //todo 要求 [dispatcher]-servlet.xml 配置文件中有配置视图渲染器
    }

    /**
     * 用于处理带参数的用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * Restful 风格的 url：todo 在请求该地址时，需要设有 {} 中的 PathVariable
     * @param request1
     * @param request2
     * @return
     */
    @RequestMapping("/{request1}/restful/{request2}.form")
    public String restful(@PathVariable String request1, @PathVariable String request2){
        System.out.println("req1 = " + request1);
        System.out.println("req2 = " + request2);
        return "hello";  //todo 要求 [dispatcher]-servlet.xml 配置文件中有配置视图渲染器
    }

    /**
     * 用于处理用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/redirect.form 该地址时，才会调用该方法
     */
    @RequestMapping(value = "/redirect2.form")
    public String forward2Page(){
        //转发实现一
        //return "/index.jsp";  // todo  要求 [dispatcher]-servlet.xml 配置文件中没有配置视图渲染器
        //return "index.jsp";  //两者皆可
        //转发实现二
        //return "forward:/index.jsp";
        //return "forward:index.jsp"; //两者皆可

        //重定向实现：todo 与 [dispatcher]-servlet.xml 配置文件中是否配置视图渲染器无关
        //return "redirect:/index.jsp";
        return "redirect:index.jsp";  //两者皆可

    }

    /**
     * 用于处理用户请求，并进行转发或者重定向
     * 设置返回值 String，使用 SpringMVC 方式进行重定向与转发
     * 只有在用户请求 /SpringMVC/redirect.form 该地址时，才会调用该方法
     */
    @RequestMapping(value = "/redirect.form")
    public String forwardPage(){
        //转发实现一
        //return "/hello";  // todo  要求 [dispatcher]-servlet.xml 配置文件中有配置视图渲染器
        return "hello";  //两者皆可
        //转发实现二
        //return "forward:/hello";
        //return "forward:hello"; //两者皆可

        //重定向实现：todo 与 [dispatcher]-servlet.xml 配置文件中是否配置视图渲染器无关
        //return "redirect:/index.jsp";
        //return "redirect:index.jsp";  //两者皆可

    }


}
