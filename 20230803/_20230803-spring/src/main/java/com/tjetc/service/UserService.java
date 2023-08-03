package com.tjetc.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    //    @Component        一般组件
    //    @Repository       一般用在Dao操作数据库类
    //    @Service          一般用在Service业务类
    //    @Controller       一般用在控制器的类
    public UserService() {
        System.out.println("构造方法User Service。。。。。。。。。。。。");
    }

    public void add() {
        System.out.println("实例方法add。。。。。。。。。。。。");
    }

    public void init() {
        System.out.println("初始化。。。");
    }

    public void destroy() {
        System.out.println("销毁。。。");
    }
}
