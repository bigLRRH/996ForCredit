package com.tjetc.controller;

import com.tjetc.model.params.UserParam;
import com.tjetc.model.views.UserView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RestController=@Controller+@ResponseBody
@RestController
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

    @RequestMapping("user/info")
//    把对象转换json字符串返回给前端
//    @ResponseBody
    public UserView userView() {
        UserView userView = new UserView();
        userView.setId(100);
        userView.setUsername("zhangsan");
        userView.setPassword("789");
        return userView;
    }

//
    @PostMapping("user/save")
    public String saveUserInfo(@RequestBody UserParam userParam) {
        System.out.println(userParam);
        return "user save success";
    }

}
