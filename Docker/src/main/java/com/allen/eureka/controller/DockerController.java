package com.allen.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能:
 *
 * @date: 2018-10-23 17:12
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@RestController
public class DockerController {
    
    @RequestMapping("/")
    public String index() {
        return "Hello Docker!";
    }
}