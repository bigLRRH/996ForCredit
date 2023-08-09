package com.tjetc.entity;


import lombok.Data;

import java.io.Serializable;

@Data
//默认把Person要按照序列化的方式存储到redis中，需要Person实现serializable接口
public class Person implements Serializable {
    private String name;
    private Integer age;
}
