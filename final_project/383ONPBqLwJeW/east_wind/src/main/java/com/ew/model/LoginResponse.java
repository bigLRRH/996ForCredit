package com.ew.model;

import com.ew.common.response.ResponseData;
import lombok.Getter;

@Getter
public class LoginResponse extends ResponseData {
    Long id;
    String token;

    public LoginResponse(Long id, String token) {
        super(0, "Login successful");
        this.id = id;
        this.token = token;
    }
}
