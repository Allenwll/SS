package com.allen.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka是Netflix开源的一款提供服务注册和发现的产品，它提供了完整的Service Registry和Service Discovery实现
 * 服务中心又称注册中心，管理各种服务功能包括服务的注册、发现、熔断、负载、降级等，比如 dubbo admin后台的各种功能
 */
/**
 * Eureka由两个组件组成：Eureka服务器和Eureka客户端。Eureka服务器用作服务注册服务器。
 *
 * Eureka客户端是一个java客户端，用来简化与服务器的交互、作为轮询负载均衡器，并提供服务的故障切换支持。
 *
 * Netflix在其生产环境中使用的是另外的客户端，它提供基于流量、资源利用率以及出错状态的加权负载均衡
 *
 * 1、Eureka Server
 *
 * 提供服务注册和发现
 * 2、Service Provider
 *
 * 服务提供方
 * 将自身服务注册到Eureka，从而使服务消费方能够找到
 * 3、Service Consumer
 *
 * 服务消费方
 * 从Eureka获取注册服务列表，从而能够消费服务
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    
    public static void main(String[] args) {
        
        /**Eureka 采用了 C-S 的设计架构。Eureka Server 作为服务注册功能的服务器，它是服务注册中心。
         * 而系统中的其他微服务，使用 Eureka 的客户端连接到 Eureka Server，并维持心跳连接。
         * 这样系统的维护人员就可以通过 Eureka Server 来监控系统中各个微服务是否正常运行。
         * Spring Cloud的一些其他模块（比如Zuul）就可以通过 Eureka Server 来发现系统中的其他微服务，并执行相关的逻辑。
         */
        SpringApplication.run(EurekaApplication.class, args);
    }
}
