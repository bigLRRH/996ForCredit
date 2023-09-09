package com.ew.service;

import com.ew.common.response.ResponseData;
import com.ew.enums.Role;
import com.ew.enums.EnumPermissionStatus;
import com.ew.model.LoginForm;
import org.springframework.http.ResponseEntity;


public interface AuthService {
    ResponseEntity<ResponseData> login(LoginForm loginForm);

    EnumPermissionStatus getPermissionStatus(Role permission, Role requiredPermission);
}
