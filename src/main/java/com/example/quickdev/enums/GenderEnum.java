package com.example.quickdev.enums;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/16 9:11
 */
public enum GenderEnum {

    /**
     * 男性
     */
    MALE("男"),

    /**
     * 女性
     */
    FEMALE("女");

    private String value;

    private GenderEnum(String value) {
        this.value = value;
    }

}
