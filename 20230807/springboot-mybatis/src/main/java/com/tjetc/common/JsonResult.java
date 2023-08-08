package com.tjetc.common;

import lombok.Getter;

@Getter
public class JsonResult <T>{
//    状态码 0表示成功 大于0表示失败 小于0表示未登录或者登录过期
    private Integer state;
//    错误消息   后端处理失败后错误消息
    private String message;
//    结果集   操作结果正确，返回的数据
    private T data;
    public JsonResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
}
