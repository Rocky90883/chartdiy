package com.atguigu.springboot.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class LoginViewController {

    @Autowired
    private RestTemplate restTemplate;

    private final String LOGIN_INFO_ADDRESS = "http://localhost:8080/userinfo?token=";

    @RequestMapping("/index")
    public String toindex(@CookieValue(required = false,value = "TOKEN")Cookie cookie, HttpSession session){

        if(cookie!=null){
            String token = cookie.getValue();
            System.out.println(token);
            if(!StringUtils.isEmpty(token)){
                Map result = restTemplate.getForObject(LOGIN_INFO_ADDRESS + token, Map.class);
                session.setAttribute("loginuser",result);
            }
        }

        return "bootstrapTheme/index";
    }

        @RequestMapping("/login")
    public String tologin(){
        return "bootstrapTheme/login";
    }

}
