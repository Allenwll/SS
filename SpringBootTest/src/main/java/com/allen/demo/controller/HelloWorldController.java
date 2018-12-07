package com.allen.demo.controller;

import com.allen.demo.domain.LoverProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能:
 *
 * @date: 2018-10-08 10:57
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
//@Controller 和 @ResponseBody 注解的合体
//@RestController
@Controller
public class HelloWorldController {
    /* 属性多会繁琐而且可能会造成类的臃肿
    @Value("${name}")
    private String name;
    
    @Value("${age}")
    private String age;*/
    
    //装载到类中
    @Autowired
    private LoverProperties loverProperties;
    
    @RequestMapping("/hello")
    public String hello() {
        //测试
        return loverProperties.getName()+"\n"+loverProperties.getAge()+"\n"+loverProperties.getContent();
    }
}
