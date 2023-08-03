package com.tjetc.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//四大注解（"名称”) 这单名称相当子bean标签id值
//@Component("adminCon")
//
@Component
public class AdminContent {
    //    @Value注入前提是本类要就给spring管理
//    去读admin.properties的image.baseurz值，并且注入到成员变量中
//    SpEl
    @Value("${image.baseUrl}")
    private String imageBaseUrl;
    private String imageType;
    //    @Value也可以直接写一个固定值
    @Value("aaaaaaaaaaaa")
    private String str;

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public void setImageBaseUrl(String imageBaseUrl) {
        this.imageBaseUrl = imageBaseUrl;
    }

    public String getImageType() {
        return imageType;
    }

    //    去读admin.properties的image。types值，并且作为参数注入到setImageTypes方法中
    @Value("${image.types}")
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public String toString() {
        return "AdminContent{" +
                "imageBaseUrl='" + imageBaseUrl + '\'' +
                ", imageType='" + imageType + '\'' +
                '}';
    }
}
