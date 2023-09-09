package com.ew.service;


import com.ew.entity.Captcha;
import com.ew.model.Base64Model;

import java.io.IOException;

public interface CaptchaService {
    //生成验证码
    Base64Model generateCaptchaModel();
    //验证验证码
    boolean verifyCaptcha(Captcha captcha);
}
