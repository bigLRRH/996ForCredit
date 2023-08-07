package com.tjetc.entity;

import lombok.Data;

@Data //通过Lombok插件生成getter和setter还有tostring
//@Getter
//@Setter
public class User {
    private Long id;
    private String username;
    private String password;
}
