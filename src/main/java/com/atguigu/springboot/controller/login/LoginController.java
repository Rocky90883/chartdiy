package com.atguigu.springboot.controller.login;

import com.atguigu.springboot.my.bean.User;
import com.atguigu.springboot.utils.LoginCacheUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class LoginController {

    private static Set<User> dbuser;
    static{
        dbuser = new HashSet<>();
        dbuser.add(new User(1,"zhangsan","1","123456"));
        dbuser.add(new User(2,"lisi","1","12345"));
        dbuser.add(new User(3,"wangwu","1","1234"));
    }

    @RequestMapping(value="/dologin" , method = RequestMethod.POST)
    public String dologin(User user , HttpSession session, HttpServletResponse response){

        String target = (String) session.getAttribute("target");

        if(target==null || target.equals("")){
            target = "/view/index";
        }

        Optional<User> first = dbuser.stream().filter(dbuser -> dbuser.getUsername().equals(user.getUsername()) &&
                dbuser.getPassword().equals(user.getPassword())).findFirst();

        if(first.isPresent()){
            String token = UUID.randomUUID().toString();
            LoginCacheUtil.loginuser.put(token,first.get());
            session.setAttribute("loginuser",first.get());
            Cookie cookie = new Cookie("TOKEN",token);
            cookie.setDomain("Dashboard");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
        }else{
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:/view/login";
        }

        return "redirect:" + target;
    }

    @GetMapping("userinfo")
    @ResponseBody
    public ResponseEntity<User> getUserInfo(String token){
        if(!StringUtils.isEmpty(token)){
            User user = LoginCacheUtil.loginuser.get(token);
            return ResponseEntity.ok(user);
        }else{
            return new ResponseEntity<>((MultiValueMap<String, String>) null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method=RequestMethod.GET, value = "/logout")
    public void logOut(@CookieValue(required = false,value = "TOKEN")Cookie cookie, HttpServletResponse response){

        System.out.println(cookie.getName());
        System.out.println(cookie.getValue());
        System.out.println(cookie.getMaxAge());

    }
}
;