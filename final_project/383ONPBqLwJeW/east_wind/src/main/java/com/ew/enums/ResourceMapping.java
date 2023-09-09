package com.ew.enums;

import lombok.Getter;

@Getter
public enum ResourceMapping {
    User("user", "com.ew.entity.User"),
    Item("item", "com.ew.entity.Captcha"),
    ;
    private final String resourceName;
    private final String className;

    ResourceMapping(String resourceName, String className) {
        this.resourceName = resourceName;
        this.className = className;
    }

    public static ResourceMapping getResourceMapping(String resourceName) {
        ResourceMapping[] values = ResourceMapping.values();
        for (ResourceMapping value : values) {
            if (value.resourceName.equals(resourceName)) {
                return value;
            }
        }
        return null;
    }
}
