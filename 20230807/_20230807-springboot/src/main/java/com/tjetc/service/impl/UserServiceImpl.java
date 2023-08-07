package com.tjetc.service.impl;

import com.tjetc.service.UserService;

public class UserServiceImpl implements UserService {
    public UserServiceImpl(){
        System.out.println("com.tjetc.service.impl.UserServiceImpl UserServiceImpl() called");
    }

    public void save(){
        System.out.println("com.tjetc.service.impl.UserServiceImpl save() called");
    }

    @Override
    public void init() {
        System.out.println("com.tjetc.service.impl.UserServiceImpl init() called");
    }
}
