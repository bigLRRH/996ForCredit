package com.ew.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestRestMapper {
    @Autowired
    RestMapper restMapper;

    @Test
    public void testQueryAll() {
        List<Map<String, Object>> objs = restMapper.getAll("`user`");
        System.out.println(objs);
    }

    @Test
    void testGetById() {
        Map<String, Object> obj1 = restMapper.getById("`user`", 1L);
        System.out.println(obj1);
        Map<String, Object> obj2 = restMapper.getById("`user`", 1000L);
        System.out.println(obj2);
    }

    @Test
    void testInsert() {
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("username", "aaaaaaa");
        myMap.put("password", "654321");
        Integer rows = restMapper.insert("`user`", myMap);
        System.out.println(rows);
    }

    @Test
    void testUpdate() {
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("username", "abcde");
        myMap.put("password", "654321");
        Integer rows = restMapper.update("`user`", 4L, myMap);
        System.out.println(rows);
    }

    @Test
    void testDelete() {
        Integer rows = restMapper.deleteById("`user`", 7L);
        System.out.println(rows);
    }
}
