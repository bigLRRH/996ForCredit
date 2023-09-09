package com.ew.service.impl;

import com.ew.dao.UserMapper;
import com.ew.entity.User;
import com.ew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.queryAll();
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        List<User> users = queryByUser(user);
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {

        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    public List<User> queryByUser(User user) {
//        todo 增加用户名判断
        return userMapper.queryByUser(user);
    }

    @Override
    public User findByUsername(String userName) {
        User user = new User();
        user.setUsername(userName);
        List<User> users = queryByUser(user);
        if (users.size() > 1) {
            throw new RuntimeException("用户名重复，查询多个用户，请联系管理员");
        }
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
