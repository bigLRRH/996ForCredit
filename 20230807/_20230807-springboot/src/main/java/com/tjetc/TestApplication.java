package com.tjetc;

import com.tjetc.config.MyDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//启动类
@SpringBootApplication
@Import(MyDataSource.class)//springboot启动过程中  创建MyDatasource类型的bean对象交给容器管理
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}