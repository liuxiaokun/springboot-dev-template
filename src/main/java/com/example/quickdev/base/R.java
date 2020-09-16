package com.example.quickdev.base;

import lombok.Data;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 9:51
 */
@Data
public class R {

    private Boolean success;
    private int code;
    private String message;

    public static RO success() {
        RO ro = new RO();
        ro.setSuccess(true);
        ro.setCode(RCodeEnum.SUCCESS.getCode());
        ro.setMessage(RCodeEnum.SUCCESS.getMessage());
        return ro;
    }
}
