package com.tjetc.dao;

import com.tjetc.entity.User;

import java.util.List;

public interface UserMapper {
    //    查询所有的用户，返回List集合，集合中每个元素是User对象
    List<User> queryList();

    //    根据id查找
    User queryById(Long id);

    //    insert
    int insert(User user);
}
