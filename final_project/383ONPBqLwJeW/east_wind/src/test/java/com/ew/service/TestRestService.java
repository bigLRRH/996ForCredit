package com.ew.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestRestService {
    @Autowired
    RestService restService;
    @Test
    public void testSelectAll(){
        System.out.println(restService.getAll("`user`"));
    }
}
