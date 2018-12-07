package com.allen;

import com.allen.config.MemcachedRunner;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedApplicationTests {
    
    @Resource
    private MemcachedRunner memcachedRunner;
    
    @Test
    public void contextLoads() {
    }
    
    @Test
    public void testSetGet() {
        MemcachedClient client = memcachedRunner.getClient();
        client.set("testKey", 3000, "666666"); //过期时间单位为 毫秒
        System.out.println("***********  " + client.get("testKey").toString());
    }
    
}
