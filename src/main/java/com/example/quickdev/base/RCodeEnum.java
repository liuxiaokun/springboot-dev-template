package com.example.quickdev.base;

import lombok.Getter;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 9:59
 */
@Getter
public enum RCodeEnum {

    /**
     * 操作成功
     */
    SUCCESS(1, "操作成功"),
    /**
     * 操作失败
     */
    FAIL(-1, "操作失败");

    private Integer code;
    private String message;

    private RCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
