package com.tjetc.controller;

import com.tjetc.common.JsonResult;
import com.tjetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public JsonResult test() {
        userService.test();
        return new JsonResult(0, "", "test");
    }

    @RequestMapping("npe")
    public JsonResult test1() {
        userService.test1();
        return new JsonResult(0, "", "npe");
    }

    @RequestMapping("test2")
    public JsonResult test2() {
        userService.test2();
        return new JsonResult(0, "", "test2");
    }
}
