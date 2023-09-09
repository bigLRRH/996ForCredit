package com.ew.service.impl;

import com.ew.enums.Role;
import com.ew.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TokenServiceImpl implements TokenService {
    private final String PREFIX = "token:";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String generateToken(Role permission) {
        String token;
        String key;
        do {
//      todo 生成高级token
            token = UUID.randomUUID().toString();
            key = PREFIX + token;
        } while (redisTemplate.hasKey(key));
//        存token 4小时后删除
        redisTemplate.opsForValue().set(key, String.valueOf(permission.getRoleCode()), 4, TimeUnit.HOURS);
        return token;
    }

    public Role getPermissionByTokenValue(String token) {
        String key = PREFIX + token;
        String code = redisTemplate.opsForValue().get(key);
        if (code == null)
            return null;
        return Role.getRole(Integer.valueOf(code));
    }

    @Override
    public void deleteToken(String tokenValue, Long timeout, TimeUnit timeUnit) {
        String key = PREFIX + tokenValue;
        redisTemplate.expire(key, timeout, timeUnit);
    }
}