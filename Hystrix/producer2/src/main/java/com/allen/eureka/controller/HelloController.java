package com.allen.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "小哥哥 "+name+"，你好，现在是二号服务商为您提供的服务哟~";
    }
}