package com.ew.common.response;

import com.ew.common.response.ResponseData;
import lombok.Getter;

@Getter
public class JsonResult<T> extends ResponseData {
    private T data;

    public JsonResult(Integer state, String msg, T data) {
        super(state, msg);
        this.data = data;
    }
}
