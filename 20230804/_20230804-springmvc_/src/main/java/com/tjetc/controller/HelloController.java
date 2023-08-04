package com.tjetc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    //    @RequestMapping 作用是把url请求映射成controller内的方法，url请求就会执行映射对应的方法
    @RequestMapping("/hello")
    public String hello(Model model) {
        System.out.println("HelloController.hello() called");
//        把数据存储model中，响应
        model.addAttribute("msg", "Hello springmvc");
//        表示返回页面 /hello.jsp, 把/hello.jsp页面的内容输出到客户端
        return "hello";
    }
}
