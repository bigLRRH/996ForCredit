package com.tjetc;

import com.tjetc.common.MyBean;
import com.tjetc.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        MyBean myBean1 = ctx.getBean(MyBean.class);
        MyBean myBean2 = ctx.getBean(MyBean.class);
        System.out.println(myBean1 == myBean2);

        UserService userService = (UserService) ctx.getBean("userService");
        ctx.close();
    }
}
