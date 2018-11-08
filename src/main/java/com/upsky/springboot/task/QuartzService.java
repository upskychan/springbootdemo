package com.upsky.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Spring Boot 整合Spring的scheduling定时任务。
 */
@Component
public class QuartzService {
    /**
     * 每分钟执行一次
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow(){
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * fixedRate:上一次 启动时间点之后 X秒执行一次.
     */
    @Scheduled(fixedRate = 5000)
    public void timerToZZP(){
        System.out.println("ZZP:" + new Random().nextLong() + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    /**
     * fixedDelay:上一次 结束时间点之后 每X秒执行一次.
     */
    @Scheduled(fixedDelay = 50000)
    public void timerToReportCount(){
        for (int i = 0; i < 10; i++){
            System.out.println("<================its" + i + "count===============>" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

    /**
     * initialDelay+fixedRate:第一次延迟 X秒执行，之后按照fixedRate的规则每X秒执行.
     */
    @Scheduled(initialDelay = 50000,fixedRate = 6000)
    public void timerToReport(){
        for (int i = 0; i < 10; i++){
            System.out.println("<================delay :" + i + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "count===============>");
        }
    }
}
