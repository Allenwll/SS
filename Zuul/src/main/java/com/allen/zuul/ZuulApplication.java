package com.allen.zuul;

import com.allen.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Eureka用于服务的注册于发现，
 * Feign支持服务的调用以及均衡负载，
 * Hystrix处理服务的熔断防止故障扩散，
 * Spring Cloud Config服务集群配置中心
 * Zuul是Netflix出品的一个基于JVM路由和服务端的负载均衡器 提供动态路由，监控，弹性，安全等的边缘服务
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
    
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
