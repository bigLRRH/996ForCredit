package com.tjetc.enums;

public enum EnumSex {
    MALE(1, "男"),
    FEMALE(0, "女");

    public static EnumSex getByCode(int code) {
        for (EnumSex sex : EnumSex.values()) {
            if (sex.getCode() == code) {
                return sex;
            }
        }
        return null;
    }

    private int code;

    private String name;

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
