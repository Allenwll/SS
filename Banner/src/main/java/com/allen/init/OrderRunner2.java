package com.allen.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 功能:初始化多个资源  @Order(1)  注解  值越小  越在前
 *
 * @date: 2018-10-25 15:41
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
@Order(2)
public class OrderRunner2 implements CommandLineRunner{
    @Override
    public void run(final String... strings) throws Exception {
        System.out.println("OrderRunner2进行初始化 ...\n");
    }
}
