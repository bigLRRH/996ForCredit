package com.tjetc.controller;

import com.tjetc.config.MyDataSource;
import com.tjetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MyDataSource myDataSource;
    @RequestMapping("save")
    public String save(){
        System.out.println("com.tjetc.controller.UserController");
        userService.save();
        return "save user success";
    }

    @RequestMapping("dataSource")
    public MyDataSource dataSource(){
        return myDataSource;
    }
}
