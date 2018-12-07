package com.allen.consumer.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能:
 *
 * @date: 2018-11-06 17:32
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
public class HelloRemoteHystrix implements HelloRemote{
    @Override
    public String hello(@RequestParam(value = "name")  String name) {
        return "小哥哥" +name+",不好意思 信息失败了呢 ";
    }
}
