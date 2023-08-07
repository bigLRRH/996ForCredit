package com.tjetc.service;

import com.tjetc.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    Long save(User user);
    Boolean deleteById(Long id);
}
