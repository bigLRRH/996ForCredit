package com.tjetc.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:admin.properties")
@ConfigurationProperties(prefix = "image")
@Data
public class ImageInfo {
    private String basePath;
}
