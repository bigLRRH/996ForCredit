package com.ew.service;

import com.ew.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    boolean deleteUser(Long id);
    List<User> queryByUser(User user);
    User findByUsername(String username);
}
