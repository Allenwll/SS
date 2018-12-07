package com.allen.zuul.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能:当我们的后端服务出现异常的时候，我们不希望将异常抛出给最外层，期望服务可以自动进行一降级
 * 自定义的fallback方法，并且将其指定给某个route来实现该route访问出问题的熔断处理
 *
 *  zuul 目前只支持服务级别的熔断，不支持具体到某个URL进行熔断。
 * @date: 2018-11-09 15:33
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
public class ProducerFallback implements ZuulFallbackProvider {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerFallback.class);
    
    //指定要处理的service  指明熔断拦截哪个服务
    @Override
    public String getRoute() {
        return "spring-cloud-producer";
    }
    
    //告诉 Zuul 断路出现时，它会提供一个什么返回值来处理请求
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
            
            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }
            
            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }
            
            @Override
            public void close() {
            
            }
            
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("The Service is unavailable.".getBytes());
            }
            
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
    
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            LOGGER.info("Exception:", reason);
        }
        return fallbackResponse();
    }
    
}
