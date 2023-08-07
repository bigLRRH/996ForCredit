package com.tjetc.controller;

import com.tjetc.entity.User;
import com.tjetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("all")
    public List<User> all() {
        return userService.findAll();
    }

    @RequestMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }
}
