package com.allen.demo;

import com.allen.demo.mq.ZyhSender;
import com.allen.demo.mq.entity.User;
import com.allen.demo.mq.many.OneManySender;
import com.allen.demo.mq.many.TwoManySender;
import com.allen.demo.mq.one.OneToManySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 功能:
 *
 * @date: 2018-10-12 10:13
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
    @Autowired
    private ZyhSender zyhSender;
    
    @Autowired
    private OneToManySender oneToManySender;
    
    @Autowired
    private OneManySender oneManySender;
    
    @Autowired
    private TwoManySender twoManySender;
    
    
    @Test
    public void hello() throws Exception {
       // zyhSender.send();
        
        User user=new User();
        user.setName("ZYH");
        user.setPwd("000000");
        zyhSender.send(user);
    }
    
    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            oneToManySender.send(i);
        }
    }
    
    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            oneManySender.send(i);
            twoManySender.send(i);
        }
    }
    
}
