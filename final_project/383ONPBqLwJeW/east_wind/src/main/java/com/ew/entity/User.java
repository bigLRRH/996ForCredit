package com.ew.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer roleCode;
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password, Integer roleCode) {

    }
}
