package com.tjetc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//日描Mapper接口，利用动态代理技术根据接口生成对应的实现类，并生成bean对象交给springboot容器管理
@MapperScan(basePackages = "com.tjetc.dao")
public class SpringBootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }
}
