package com.ew.dao;

import com.ew.entity.User;
import com.ew.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestUserMapper {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectAll() throws Exception {
        List<User> users = userMapper.queryAll();
        System.out.println(users);
    }

    @Test
    public void testSelectByUser() {
        User user = new User();
//        todo 重构role code
        user.setRoleCode(Role.SHOP_ASSISTANT.getRoleCode());
        List users = userMapper.queryByUser(user);
        System.out.println(users);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        int rows = userMapper.insert(user);
        System.out.println(rows);

        List<User> users = userMapper.queryAll();
        System.out.println(users);
    }
}