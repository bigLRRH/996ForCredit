package com.ew.service.impl;

import com.ew.common.response.ResponseData;
import com.ew.entity.Captcha;
import com.ew.entity.User;
import com.ew.enums.EnumPermissionStatus;
import com.ew.enums.Role;
import com.ew.model.LoginForm;
import com.ew.model.LoginResponse;
import com.ew.service.AuthService;
import com.ew.service.CaptchaService;
import com.ew.service.TokenService;
import com.ew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    CaptchaService captchaService;
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    public ResponseEntity<ResponseData> login(LoginForm loginForm) {
        String code = loginForm.getCode();
        String uuid = loginForm.getUuid();
        // 验证验证码
        if (!captchaService.verifyCaptcha(new Captcha(code, uuid))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseData(1, "验证码错误"));
        }
        //        验证用户名和密码
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        User storedUser = userService.findByUsername(username);
        if (storedUser == null || !password.equals(storedUser.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseData(1, "用户名或密码不存在"));
        // 用户名和密码验证通过，执行登录逻辑
        // boolean rememberMe = loginRequest.isRememberMe();
        //生成token
//        todo 重构
        String token = tokenService.generateToken(Role.getRole(storedUser.getRoleCode()));
        // 返回登录成功的结果
        return ResponseEntity.ok(new LoginResponse(storedUser.getId(), token));
    }

    @Override
    public EnumPermissionStatus getPermissionStatus(Role permission, Role requiredPermission) {
        System.out.println("\033[32mAuthServiceImpl getPermissionStatus(Role permission, Role requiredPermission) called\033[0m");
        System.out.println("permission:" + permission);
        System.out.println("requiredPermission:" + requiredPermission);
        if (permission == null) {
            return EnumPermissionStatus.LOGIN_EXPIRED;
        }
        if (permission.hasPermission(requiredPermission)) {
            return EnumPermissionStatus.GRANTED;
        } else {
            return EnumPermissionStatus.NO_RELEVANT_PERMISSION;
        }
    }
}