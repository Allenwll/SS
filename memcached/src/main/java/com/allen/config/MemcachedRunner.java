package com.allen.config;

import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * 功能:  初始化资源
 *
 * @date: 2018-10-26 11:45
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
public class MemcachedRunner implements CommandLineRunner {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MemcachedRunner.class);
    
    @Resource
    private MemcachedSource memcachedSource;
    
    private MemcachedClient client = null;
    
    @Override
    public void run(final String... strings) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(memcachedSource.getIp(), memcachedSource.getPort()));
        } catch (Exception e) {
            LOGGER.error("初始化MemcachedClient出现异常", e);
        }
    }
    
    public MemcachedClient getClient() {
        return client;
    }
}
