package com.tjetc.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public class ScheduleDemo {
    @Scheduled(cron = "0/2 * * * * *")
    public void test() {
        System.out.println("timenow:" + LocalDateTime.now());
    }
}