package com.allen.demo.mq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能:
 *  可以根据routing_key自由的绑定不同的队列
 * @date: 2018-10-15 10:24
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Configuration
public class TopicRabbitConfig {
    
    final static String message = "topic.message";
    final static String messages = "topic.messages";
    
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }
    
    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }
    
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
    
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
    
}
