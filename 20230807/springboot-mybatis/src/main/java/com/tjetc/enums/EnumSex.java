package com.tjetc.enums;

//自定义性别枚举类
public enum EnumSex {
    //枚举对象
    MALE(1, "男"),
    FEMALE(0, "女");

    //根据code值返回枚举对象
    public static EnumSex getByCode(int code) {
        //获取所有的枚举
        EnumSex[] values = EnumSex.values();
        //遍历所有的枚举数据，根据code值判断枚举对象并返回
        for (EnumSex value : values) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    //成员变量
    private int code;
    private String name;

    //构造方法
    EnumSex(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
