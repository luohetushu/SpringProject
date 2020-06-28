package com.spring.mvc.controller;

import com.spring.mvc.beans.HeiseiRider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器：用于处理用户请求，并封装响应到视图的数据
 * 使用注解方式：自定义处理用户请求并封装响应数据的方法
 * todo 该控制器是单例模式，在服务器启动时创建对象
 */
@Controller
public class JsonController {
    /**
     * 用于处理用户请求，并封装响应到视图的数据
     * 只有在用户请求 /SpringMVC/json/list.form 该地址时，才会调用该方法
     * @return 将返回的数据转换成 json 格式，再响应到视图
     */
    @RequestMapping("/json/list.form")
    @ResponseBody  //@return 将返回的数据转换成 json 格式，再响应到视图
    public List<HeiseiRider> returnList(){
        List<HeiseiRider> lists = new ArrayList<>();

        HeiseiRider rider1 = new HeiseiRider("Den-O", 2, "2007-09-01");
        HeiseiRider rider2 = new HeiseiRider("Drive", 3, "2015-09-01");
        lists.add(rider1);
        lists.add(rider2);

        return lists;
    }

}
