package com.allen.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "你好 " + name + "，1号服务商为您服务.";
    }
}