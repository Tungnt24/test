package com.example.test.enums;

import java.util.HashMap;
import java.util.Map;

public enum TemplateMailEnum {

    JAVA_INTERN("JAVA FRESHER"),
    JAVA_FRESHER("JAVA FRESHER"),
    ANGULAR_INTERN("ANGULAR FRESHER"),
    ANGULAR_FRESHER("ANGULAR FRESHER");

    public final String value;

    TemplateMailEnum(String value) {
        this.value = value;
    }

    private static Map<String, TemplateMailEnum> map = new HashMap<>();

    static {
        for (TemplateMailEnum status : TemplateMailEnum.values()) {
            map.put(status.value, status);
        }
    }
}
