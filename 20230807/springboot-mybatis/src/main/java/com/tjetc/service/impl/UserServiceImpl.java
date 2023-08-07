package com.tjetc.service.impl;

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
}
