package com.tjetc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.common.JsonResult;
import com.tjetc.dao.UserMapper;
import com.tjetc.entity.User;
import com.tjetc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList();
    }

    @Override
    public Long save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Boolean deleteById(Long id) {
        int rows = userMapper.deleteById(id);
        return rows > 0;
    }

    @Override
    public PageInfo page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectList();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;

    }

    @Override
    public void test() {
//        try{
//            int i = 10 / 0;
//            System.out.println("com.tjetc.services.Userservice test() called");
//        }catch(Exception e){
//            e.printStackTrace();
//        }

//        除零异常
        int i = 10 / 0;
        System.out.println("com.tjetc.services.Userservice test() called");
    }

    @Override
    public void test1() {
        String str = null;
//        空指针
        System.out.println(str.length());
        System.out.println("com.tjetc.services.Userservice test1() called");
    }

    @Override
    public void test2() {
        String[] strs = new String[1];
//        数组越界
        System.out.println(strs[3]);
        System.out.println("com.tjetc.services.Userservice test2() called");
    }

    @Override
    public JsonResult login(String username, String password) {
        List<User> users = userMapper.selectByUsernameAndPassword(username, password);
        if (users.size() > 1) {
            throw new RuntimeException("用户名重复，查询多个用户，请联系管理员");
        }
        if (users.size() == 0) {
            return new JsonResult(2, "用户名或密码错误，请联系管理员", null);
        }
// 正确
        return new JsonResult(0, "", users.get(0));
    }


}
