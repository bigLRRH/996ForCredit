package com.ew.interceptors;

import com.ew.enums.Role;
import com.ew.service.AuthService;
import com.ew.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    TokenService tokenService;
    @Autowired
    AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头或请求参数中获取令牌
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        Role permission = tokenService.getPermissionByTokenValue(token);
//        todo remove log
        System.out.println("requestPath:" + request.getRequestURI());
        System.out.println("AuthInterceptor permission:" + permission);
        System.out.println("\033[34m" + authService.getPermissionStatus(permission, getRequiredPermission(request)) + "\033[0m");
        switch (authService.getPermissionStatus(permission, getRequiredPermission(request))) {
            case GRANTED:
                response.setHeader("token", tokenService.generateToken(permission));
                return true;
            case LOGIN_EXPIRED:
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            case NO_RELEVANT_PERMISSION:
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;
            default:
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return false;
        }
    }

    private Role getRequiredPermission(HttpServletRequest request) {
        String path = request.getRequestURI();
        if (path.startsWith("/rest/system")) {
            return Role.STORE_KEEPER;
        } else if (path.startsWith("/rest/store-keeper")) {
            return Role.STORE_KEEPER;
        } else if (path.startsWith("/rest/shop-assistant")) {
            return Role.SHOP_ASSISTANT;
        } else {
            return null;
        }
    }
}