package com.tjetc;

import com.tjetc.controller.UserController;
import com.tjetc.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService1 = (UserService) ctx.getBean("userService1");
        UserService userService2 = (UserService) ctx.getBean("userService2");
        System.out.println(userService1==userService2);
        System.out.println("================================");
        UserController userController = ctx.getBean(UserController.class);
        System.out.println(userController.getUserService());
    }
}