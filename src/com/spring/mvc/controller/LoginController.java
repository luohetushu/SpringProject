package com.spring.mvc.controller;

import com.spring.mvc.beans.HeiseiRider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 */
@Controller
@RequestMapping("/admin")   //请求地址父路径
public class LoginController {

    @RequestMapping("/login.form")
    public String login(HttpSession session, HeiseiRider rider){
        if (rider.getMaleOwner().equals("泊进之介") && rider.getFemaleOwner().equals("诗岛雾子")){
            session.setAttribute("drive", rider);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

}
