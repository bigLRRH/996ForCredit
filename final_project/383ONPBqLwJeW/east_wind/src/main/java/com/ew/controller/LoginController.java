package com.ew.controller;

import com.ew.common.response.ResponseData;
import com.ew.model.Base64Model;
import com.ew.model.LoginForm;
import com.ew.service.AuthService;
import com.ew.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    CaptchaService captchaService;
    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<ResponseData> login(@RequestBody LoginForm loginForm) {
        return authService.login(loginForm);
    }

    @GetMapping("/captchaImage")
    public ResponseEntity<Base64Model> getCaptchaImage() {
        return ResponseEntity.ok(captchaService.generateCaptchaModel());
    }
}