package com.tjetc.controller;

import com.tjetc.model.params.UserParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    //    参数的名称要与url请求过来的参数key保持一致，就能接收到key对应的value
    @RequestMapping("login")
    public String login(@RequestParam(value = "username1") String username,
                        @RequestParam(value = "password", required = false, defaultValue = "111111") String password,
                        Model model) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "success";
    }

    //    般参数超过5个建议使用对象接收参数
//    使用把多个参数封装一个对象来接收，注意对象的属性名称要与请求的参数key名称保持一致
//    method 表示请求方式 {get post put 等} 不写默认get和post都能访问
//    @RequestMapping(value = "login2", method = {RequestMethod.GET, RequestMethod.POST})
//    只能接受post请求
    @PostMapping("login2")
    public String login2(UserParam userParam, Model model) {
        System.out.println("username: " + userParam.getUsername());
        System.out.println("password: " + userParam.getPassword());
        model.addAttribute("username", userParam.getUsername());
        model.addAttribute("password", userParam.getPassword());
        return "success";
    }


    //  restful格式url是动态，参数是url组成部分，参数是竹括起来，表示参数占位，使用@PathVariable注解占位参数的值
    @RequestMapping("/mm/{name}/{id}")
    public String abc(@PathVariable("name") String name1, @PathVariable("id") Integer id, Model model) {
        System.out.println("name=" + name1);
        System.out.println("id=" + id);
        model.addAttribute("username:", name1);
        model.addAttribute("id:", id);
        return "success";
    }

    @RequestMapping("aa")
    public String aa() {
        return "redirect:mm/wangwu/32";
    }

}
