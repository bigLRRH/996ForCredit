package com.ew.dao;

import com.ew.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> queryAll();

    List<User> queryByUser(User user);

    //todo implement
    int insert(User user);

    int update(User user);

    int delete(User user);

    int queryById(Long id);
}
