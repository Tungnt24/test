package com.example.test.enums;

import java.util.HashMap;
import java.util.Map;

public enum TemplateCode {
    TMP01("TMP01");

    TemplateCode(String value) {
        this.value = value;
    }

    public final String value;
    private static Map<String, TemplateCode> map = new HashMap<>();

    static {
        for (TemplateCode status : TemplateCode.values()) {
            map.put(status.value, status);
        }
    }


}
