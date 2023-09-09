package com.ew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//日描Mapper接口，利用动态代理技术根据接口生成对应的实现类，并生成bean对象交给springboot容器管理
@MapperScan(basePackages = "com.ew.dao")
@EnableScheduling//开启定时任务功能
@EnableAsync//开启异步
@EnableTransactionManagement//开启事务管理
public class EastWind {
    public static void main(String[] args) {
        SpringApplication.run(EastWind.class, args);
    }
}
