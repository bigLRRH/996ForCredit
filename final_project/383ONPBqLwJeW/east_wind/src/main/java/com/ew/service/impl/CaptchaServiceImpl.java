package com.ew.service.impl;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import com.ew.entity.Captcha;
import com.ew.model.Base64Model;
import com.ew.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class CaptchaServiceImpl implements CaptchaService {
    private final String PREFIX = "captcha:";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Base64Model generateCaptchaModel() {
//        生成uuid
        String uuid;
        String key;
        do {
            uuid = UUID.randomUUID().toString();
            key = PREFIX + uuid;
        } while (redisTemplate.hasKey(key));
        //        生成验证码
        AbstractCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 40, 4, 4);
        String code = lineCaptcha.getCode();
        String img = lineCaptcha.getImageBase64();
//        存验证码 5分钟后删除
        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
//        返回
        return new Base64Model(uuid, img);
    }

    @Override
    public boolean verifyCaptcha(Captcha captcha) {
        String key = PREFIX + captcha.getUuid();
        String storedCode = redisTemplate.opsForValue().get(key);
        return storedCode != null && storedCode.equalsIgnoreCase(captcha.getCode());
    }
}
