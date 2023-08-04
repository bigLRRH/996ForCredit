package com.tjetc;

import com.tjetc.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.add();
        orderService.update();
        orderService.ate("a");
        orderService.bte("b",1);
        context.close();
        orderService.delete();
    }
}