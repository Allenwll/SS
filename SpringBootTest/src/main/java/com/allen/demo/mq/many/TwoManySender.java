package com.allen.demo.mq.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 功能: 一对多
 *
 * @date: 2018-10-12 10:06
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class TwoManySender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    public void send(int count){
        
        String content="多对多 "+new Date();
        System.out.println("Sender 1:"+content+"*****"+count);
        this.rabbitTemplate.convertAndSend("many_to_many",content);
    }
}
