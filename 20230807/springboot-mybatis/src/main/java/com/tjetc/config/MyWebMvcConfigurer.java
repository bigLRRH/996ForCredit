package com.tjetc.config;

import com.tjetc.common.ImageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    ImageInfo imageInfo;
    //    实现添加资源处理器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        注册自定义资源处理器
//        对哪个写urL路径进行处理（/**表示所有的请求处理）
        registry.addResourceHandler("/**")
//                资源的物理路径（请求的UrL与资源的物理路径进行映射）
                .addResourceLocations("classpath:/META-INF/resources/",
                        "classpath:/resources/",
                        "classpass:/static/",
                        "classpath:/public/",
                        "file:"+imageInfo.getBasePath());
    }
}
