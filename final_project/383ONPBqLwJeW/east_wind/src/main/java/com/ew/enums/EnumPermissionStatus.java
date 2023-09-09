package com.ew.enums;

import lombok.Getter;

@Getter
public enum EnumPermissionStatus {
    GRANTED(0, "通过"),
    LOGIN_EXPIRED(1, "登录过期"),
    NO_RELEVANT_PERMISSION(2, "没有相关权限");
    Integer code;
    String authStatus;

    EnumPermissionStatus(int code, String authStatus) {
        this.code = code;
        this.authStatus = authStatus;
    }

    public static EnumPermissionStatus getEnumAuthStatusByCode(Integer code) {
        EnumPermissionStatus[] values = EnumPermissionStatus.values();
        for (EnumPermissionStatus value : values) {
            if (value.code.equals(code))
                return value;
        }
        return null;
    }
}
