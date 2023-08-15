package com.tjetc.dao;

import com.tjetc.entity.Admin;

import java.util.List;

public interface AdminMapper {
    int insert(Admin admin);

    Admin queryById(Long id);

    List<Admin> queryList();
}
