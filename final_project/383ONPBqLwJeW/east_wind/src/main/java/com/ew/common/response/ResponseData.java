package com.ew.common.response;

import lombok.Getter;

@Getter
public class ResponseData {
    protected Integer state;
    protected String msg;
    public ResponseData(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }
}