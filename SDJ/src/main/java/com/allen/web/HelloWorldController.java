package com.allen.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * 功能:
 *
 * @date: 2018-10-08 11:47
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
//@Controller 和 @ResponseBody 注解的合体
//@RestController
@Controller
public class HelloWorldController {
    
    @RequestMapping("/hello")
    public String index(Model m){
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "index";
    }
}
