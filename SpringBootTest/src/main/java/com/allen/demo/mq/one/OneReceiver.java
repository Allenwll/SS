package com.allen.demo.mq.one;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 功能:
 *
 * @date: 2018-10-12 10:10
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
@RabbitListener(queues = "one_to_many")
public class OneReceiver {
    @RabbitHandler
    private void process(String content) {
        System.out.println("一对多  Receiver 1: " + content);
    }
}
