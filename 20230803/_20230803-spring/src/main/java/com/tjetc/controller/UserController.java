package com.tjetc.controller;

import com.tjetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    //    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//    @Autowired 根据类型在spring容器中查找bean，注入到成员变量或者setxxxx方法中
//    @Autowired
//    @Qualifier("userService1")//通过名称查找bean，保证唯一般不能单独使用需要联合@Autowired一起使用
    @Resource(name = "userService1")
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
        System.out.println("UserController......");
    }


    public void printUserService() {
        System.out.println(userService);
    }
}
