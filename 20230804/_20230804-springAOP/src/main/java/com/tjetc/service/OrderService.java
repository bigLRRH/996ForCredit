package com.tjetc.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void add() {
        System.out.println("OrderService.add() called");
    }

    public void update() {
        System.out.println("OrderService.update() called");
    }

    public void delete() {
        System.out.println("OrderService.delete() called");
        int i = 10 / 0;
    }

    public void ate(String s) {
        System.out.println("OrderService.a(String s) called");
    }

    public void bte(String s, Integer i) {
        System.out.println("OrderService.b(String s,Integer i) called");
    }
}