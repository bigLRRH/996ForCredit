package com.ew.entity;

import lombok.Data;

@Data
public class Captcha {
    String code;
    String uuid;
    public Captcha(){}
    public Captcha(String code, String uuid){
        this.code = code;
        this.uuid = uuid;
    }
}
