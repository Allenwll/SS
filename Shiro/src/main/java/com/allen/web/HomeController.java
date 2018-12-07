package com.allen.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 功能:
 *
 * @date: 2018-10-16 17:59
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Controller
public class HomeController {
    
    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }
    
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        System.out.println("------登录------");
        //登录失败从request中获取shiro处理的异常信息
        //shiroLoginFailure: shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("异常:" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException-->账号不存在!");
                msg = "UnknownAccountException-->账号不存在！";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException-->密码不正确!");
                msg = "IncorrectCredentialsException-->密码不正确！";
            } else if ("KaptchaValidateFailed".equals(exception)) {
                System.out.println("KaptchaValidateFailed-->验证码不正确!");
                msg = "KaptchaValidateFailed-->验证码不正确！";
            } else {
                System.out.println("其他原因-->" + exception);
                msg = "else >>" + exception;
                
            }
        }
        map.put("msg", msg);
        //不处理登录成功 由shiro处理
        return "/login";
    }
    
    @RequestMapping("/403")
    public String unAuthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }
}
