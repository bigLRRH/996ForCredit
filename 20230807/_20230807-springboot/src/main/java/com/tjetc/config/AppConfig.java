package com.tjetc.config;

import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类
//aconfiguration+@Bean方式程序员自己创建bean交给springboot容器管理，相当手spring的xml配置的<bean>标签作用
@Configuration
public class AppConfig {
//    @Bean的非静态方法创建的bean对象是单例
    @Bean(initMethod = "init")
    UserService userService(){
//        处理创建对象的细节，比如属性的值要赋值，还计算值等等
        return new UserServiceImpl();
    }

//    @Bean的注解的方法执行时机是springboot容器启动的过程中
    @Bean void abc(){
        System.out.println("com.tjetc.config.AppConfig abc() called");
        userService();
        userService();
        userService();
        userService();
        userService();
        userService();
    }
}
