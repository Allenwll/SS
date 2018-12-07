package com.allen.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能: 自定义Filter
 * 因为服务网关应对的是外部的所有请求，为了避免产生安全隐患，我们需要对请求做一定的限制，
 * 比如请求中含有Token便让请求继续往下走，如果请求不带Token就直接返回并给出提示
 *
 * @date: 2018-11-09 15:07
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class TokenFilter extends ZuulFilter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);
    
    @Override
    public String filterType() {
        return "pre"; // 可以在请求被路由之前调用
    }
    
    @Override
    public int filterOrder() {
        return 0; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }
    
    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }
    
    @Override
    public Object run() {
        RequestContext reqContext = RequestContext.getCurrentContext();
        HttpServletRequest req = reqContext.getRequest();
        
        LOGGER.info("--->>> TokenFiler {},{}", req.getMethod(), req.getRequestURL().toString());
        
        String token = req.getParameter("token");//获取请求参数
        
        if (StringUtils.isNotBlank(token)) {
            reqContext.setSendZuulResponse(true);//对请求进行路由
            reqContext.setResponseStatusCode(200);
            reqContext.set("isSuccess", true);
            return null;
        } else {
            reqContext.setSendZuulResponse(false);
            reqContext.setResponseStatusCode(400);
            reqContext.setResponseBody("token is empty");
            reqContext.set("isSuccess", false);
            return null;
        }
    }
}
