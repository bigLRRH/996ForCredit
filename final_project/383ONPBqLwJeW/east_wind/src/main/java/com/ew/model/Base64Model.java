package com.ew.model;

import com.ew.common.response.DownloadFileData;
import lombok.Getter;

@Getter
public final class Base64Model extends DownloadFileData {
    private Boolean captchaEnabled;
    private String uuid;
    private String img;
    public Base64Model(String uuid, String img){
        super(0, "captcha success", (long) img.length());
        this.captchaEnabled = true;
        this.uuid = uuid;
        this.img = img;
    }
    public Base64Model(Integer state, String msg, String uuid, String img) {
        super(state, msg, (long) img.length());
        this.captchaEnabled = true;
        this.uuid = uuid;
        this.img = img;
    }
}