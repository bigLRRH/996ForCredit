package com.tjetc;

import com.tjetc.common.AdminContent;
import com.tjetc.common.MyBean;
import com.tjetc.controller.UserController;
import com.tjetc.dao.UserDao;
import com.tjetc.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        方式一：Test类主动new方式创建UserService实例对象
//        UserService userService = new UserService();
//        方式二：通过spring的oc创建UserService对象
//        创建classPathXmlApplicationContext对象，参数是spring的配置文件
//        new ClassPathXmlApplicationContext过程读取配置文件并解析，根据配置内容进行创建对象并管理起来
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        通过上下文获取spring创建的UserService对象，根据id的名称获取的
//        UserService userService = (UserService) ctx.getBean("userService");
//        UserService userService1 = (UserService) ctx.getBean("userService");
//        对象等号判断是表示两个对象的地址是否相同，如果地址相同表示是一个对象，不同表示两个对象
//        System.out.println(userService == userService1);
//        userService.add();
//        ctx.close();

//        getBean通过类型获取Bean对象
        UserController userController = ctx.getBean(UserController.class);
        System.out.println(userController);
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = ctx.getBean(UserDao.class);
        System.out.println(userDao);
        MyBean myBean = ctx.getBean(MyBean.class);
        System.out.println(myBean);

        System.out.println("============================================");
//        AdminContent adminContent = ctx.getBean(AdminContent.class);
//        AdminContent adminContent = (AdminContent) ctx.getBean("adminCon");
        AdminContent adminContent = (AdminContent) ctx.getBean("adminContent");
        System.out.println(adminContent);
        System.out.println("============================================");
        userController.printUserService();
        ctx.close();
    }
}
