package com.ew.common.response;

import lombok.Getter;

@Getter
public class DownloadFileData extends ResponseData {
//   单位 byte
    protected Long size;

    public DownloadFileData(Integer state, String msg, Long size) {
        super(state, msg);
        this.size = size;
    }
}