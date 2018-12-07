package com.allen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 功能:  MemcacheSource 配置
 *  prefix = "memcache"
 *
 *  会以 memcache.* 为开头将对应的配置文件加载到属性中
 *
 * @date: 2018-10-26 11:40
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
@ConfigurationProperties(prefix = "memcache")
public class MemcachedSource {
    private String ip;
    
    private int port;
    
    public String getIp() {
        return ip;
    }
    
    public void setIp(final String ip) {
        this.ip = ip;
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(final int port) {
        this.port = port;
    }
}
