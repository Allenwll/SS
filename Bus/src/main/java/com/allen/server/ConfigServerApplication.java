package com.allen.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 如果需要客户端获取到最新的配置信息需要执行refresh，我们可以利用webhook的机制每次提交代码发送请求来刷新客户端，
 * 当客户端越来越多的时候，需要每个客户端都执行一遍，这种方案就不太适合了。使用Spring Cloud Bus可以完美解决这一问题。
 *
 * Spring cloud bus消息总线 通过轻量消息代理连接各个分布的节点。这会用在广播状态的变化（例如配置变化）或者其他的消息指令。
 * Spring bus的一个核心思想是通过分布式的启动器对spring boot应用进行扩展，可以用来建立一个多个应用之间的通信频道。
 *
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
