package com.allen.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能:
 *
 * @date: 2018-11-05 14:44
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/

@RestController
public class HelloController {
    
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello " + name + "，this is first message";
    }
}