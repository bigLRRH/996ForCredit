package com.tjetc.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@PropertySource 读取指定位置的properties配置文件并解析存储到springboot容器中
@PropertySource("classpath:image.properties")
@ConfigurationProperties(prefix = "image")
public class ImageInfo {
    private List<String> types;
    private String basePath;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "types=" + types +
                ", basePath='" + basePath + '\'' +
                '}';
    }
}
