package com.allen.demo.mq.many;

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
@RabbitListener(queues = "many_to_many")
public class TwoReceiver {
    @RabbitHandler
    private void process(String content) {
        System.out.println("多对多 Receiver 2: " + content);
    }
}
