package com.allen.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        LOGGER.info("2号服务商服务对象:" + name);
        try{
        Thread.sleep(1000000);
        }catch(Exception e){
            LOGGER.error("出现异常",e);
        }
        return "小哥哥 " + name + "，你好，现在是二号服务商为您提供的服务哟~";
    }
}