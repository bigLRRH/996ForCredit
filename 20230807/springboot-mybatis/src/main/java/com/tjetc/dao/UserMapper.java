package com.tjetc.dao;

import com.tjetc.entity.User;

import java.util.List;

public interface UserMapper {
    Long insert(User user);

    List<User> selectList();
    User selectById(Long id);
    int update(User user);
    int deleteById(Long id);

    List<User> selectByUsernameAndPassword(String username, String password);
}
