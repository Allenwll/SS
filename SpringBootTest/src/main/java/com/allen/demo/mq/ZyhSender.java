package com.allen.demo.mq;

import com.allen.demo.mq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 功能:
 *
 * @date: 2018-10-12 10:06
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class ZyhSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    public void send(User user){
        
        String content="Zyh "+new Date();
        /*System.out.println("Sender:"+content);
        this.rabbitTemplate.convertAndSend("zyh",content);*/
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend("object", user);
    }
}
