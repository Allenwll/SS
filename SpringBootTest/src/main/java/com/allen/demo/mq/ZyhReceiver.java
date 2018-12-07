package com.allen.demo.mq;

import com.allen.demo.mq.entity.User;
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
@RabbitListener(queues = "zyh")
public class ZyhReceiver {
  
   /* @RabbitHandler
    private void process(String content) {
        System.out.println("Receiver:" + content);
    }*/
    
    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object : " + user);
    }
}
