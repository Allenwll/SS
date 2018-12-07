package com.allen.demo.mq.many;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

/**
 * 功能:
 *
 * @date: 2018-10-12 09:52
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Configuration
public class RabbitConfig {
    
    public Queue queue(){
        return new Queue("many_two_many");
    }
}
