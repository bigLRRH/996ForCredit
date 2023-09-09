package com.ew.enums;

import lombok.Getter;

@Getter
public enum Role {
    STORE_KEEPER(1, "店长"),
    SHOP_ASSISTANT(2, "营业员");

    private Integer roleCode;
    private String permission;

    Role(Integer roleCode, String permission) {
        this.roleCode = roleCode;
        this.permission = permission;
    }

    //根据code值返回枚举对象
    public static Role getRole(Integer code) {
        //获取所有的枚举
        Role[] values = Role.values();
        //遍历所有的枚举数据，根据code值判断枚举对象并返回
        for (Role value : values) {
            if (value.roleCode.equals(code))
                return value;
        }
        return null;
    }

    //todo 转入service层
    public boolean hasPermission(Role permission) {
        System.out.println("\033[32mRole hasPermission(Role permission) called\033[0m");
        System.out.println("this.roleCode:" + this.roleCode);
        System.out.println("permission.getRoleCode():" + permission.getRoleCode());
        System.out.println("permission != null && this.roleCode <= permission.getRoleCode():");
        System.out.println(permission != null && this.roleCode <= permission.getRoleCode());
        return permission != null && this.roleCode <= permission.getRoleCode();
    }
}
