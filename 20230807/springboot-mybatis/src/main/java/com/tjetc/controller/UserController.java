package com.tjetc.controller;

import com.github.pagehelper.PageInfo;
import com.tjetc.common.JsonResult;
import com.tjetc.entity.Admin;
import com.tjetc.entity.User;
import com.tjetc.enums.EnumSex;
import com.tjetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("all")
    public JsonResult all() {
        List<User> users = userService.findAll();
        JsonResult result = new JsonResult<List<User>>(0, "", users);
        return result;
    }

    @RequestMapping("save")
    public JsonResult save(User user) {
        Long save = userService.save(user);
        JsonResult<Long> result = new JsonResult<Long>(0, "", save);
        return result;
    }

    @RequestMapping("delete/{id}")
    public JsonResult delete(@PathVariable("id") Long id, HttpSession session) {
//        if (session == null || session.getAttribute("user") == null) {
//            return new JsonResult(1, "请先登录", null);
//        }
        Boolean bl = userService.deleteById(id);
        JsonResult<Boolean> result;
        if (bl) {
            result = new JsonResult<Boolean>(0, "", bl);
        } else {
            result = new JsonResult<Boolean>(1, "", bl);
        }
        return result;
    }

    @RequestMapping("page")
    public JsonResult page(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        PageInfo pageInfo = userService.page(pageNum, pageSize);
        JsonResult<PageInfo> result = new JsonResult<PageInfo>(0, "", pageInfo);
        return result;
    }

    @RequestMapping("test")
    public JsonResult test() {
        userService.test();
        return new JsonResult(0, "", "test");
    }

    @RequestMapping("npe")
    public JsonResult test1() {
        userService.test1();
        return new JsonResult(0, "", "test1");
    }

    //    处理局部异常，只能处理当前的controller的方法，而且处理指定的异常类型
//    处理局部异常优点可以统一处理异常，不用controller的每个方法都要写try catch
//    只能处理当前的controller
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public JsonResult handlerException(Exception e) {
        e.printStackTrace();
        return new JsonResult<String>(2, "出错了，请联系管理员    ", null);
    }

    @RequestMapping("login")
    public JsonResult login(String username, String password, HttpSession session) {
        if ((username == null || "".equals(username.trim())) || (password == null || "".equals(password.trim()))) {
            return new JsonResult(1, "用户名或密码不能为空", null);
        }
//        查询用户
        JsonResult result = userService.login(username, password);
        if (result.getState() == 0) {
//            todo 登录成功，往session对象存储登录的过标记
//            springboot自动给我们传session
            User user = (User) result.getData();
//在session存储user对象，key为user字符串，value是user对象
            session.setAttribute("user", user);
        }
        return result;
    }

    @RequestMapping("saveAndUpdate")
    public JsonResult saveAdminAndUpdateUser(String num) {
        Admin admin = new Admin();
        admin.setUsername("tom"+num);
        admin.setPassword(num);
        admin.setSex(EnumSex.MALE);
        boolean bl = userService.saveAdminAndUpdateUser(admin,2L,"00000");
        if(bl){
            return  new JsonResult(1, "success",bl);
        }else{
            return  new JsonResult(1, "fail",bl);
        }
    }
}
