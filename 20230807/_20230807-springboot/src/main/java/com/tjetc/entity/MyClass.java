package com.tjetc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyClass {
    @Value("${MyClass.code}")
    private String code;
    @Value("${MyClass.className}")
    private String className;
//    @VaLue可以使spEL表达式#{}更强大可以做计算
    @Value("#{18+2}")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "code='" + code + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
