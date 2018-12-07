package com.allen.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能:
 *
 *
 * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
 *
 * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
 *
 * @Scheduled(initialDelay=1000, fixedRate=6000) ：
 *    第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
 *
 * @date: 2018-10-12 15:00
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
public class SchedulerTask {

    private  int count=0;
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    
    //每隔6秒打印
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
    
    //每隔6秒打印
    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
        
    }
}
