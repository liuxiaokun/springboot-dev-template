package com.example.quickdev.base;

import lombok.Data;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 9:51
 */
@Data
public class RO<T> extends R {

    private T data;

    public static <T> RO success(T t) {
        RO ro = new RO();
        ro.setCode(RCodeEnum.SUCCESS.getCode());
        ro.setMessage(RCodeEnum.SUCCESS.getMessage());
        ro.setData(t);
        return ro;
    }

    public static RO fail() {
        RO ro = new RO();
        ro.setCode(RCodeEnum.FAIL.getCode());
        ro.setMessage(RCodeEnum.FAIL.getMessage());
        return ro;
    }

    public static RO fail(String message) {
        RO ro = new RO();
        ro.setCode(RCodeEnum.FAIL.getCode());
        ro.setMessage(message);
        return ro;
    }
}
