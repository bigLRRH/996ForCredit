package com.tjetc.service;

import com.github.pagehelper.PageInfo;
import com.tjetc.common.JsonResult;
import com.tjetc.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    Long save(User user);
    Boolean deleteById(Long id);

    PageInfo page(int pageNum, int pageSize);

    void test();
    void test1();
    void test2();

    JsonResult login(String username, String password);
}
