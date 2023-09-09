package com.ew.service;

import com.ew.enums.Role;

import java.util.concurrent.TimeUnit;

public interface TokenService {
    String generateToken(Role permission); // 生成令牌
    Role getPermissionByTokenValue(String tokenValue);
    void deleteToken(String tokenValue, Long timeout, TimeUnit timeUnit);
}
