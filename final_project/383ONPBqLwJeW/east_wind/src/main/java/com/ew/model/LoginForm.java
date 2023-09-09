package com.ew.model;

import lombok.Data;

@Data
public class LoginForm {
    private String username;
    private String password;
//    记住密码
//    private boolean rememberMe;
//    验证码相关
    private String code;
    private String uuid;
}
