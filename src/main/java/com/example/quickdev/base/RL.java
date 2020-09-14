package com.example.quickdev.base;

import lombok.Data;

import java.util.List;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 9:51
 */
@Data
public class RL<T> extends RO {

    private List<T> data;

    public static <T> RL success(List<T> list) {
        RL rl = new RL();
        rl.setCode(RCodeEnum.SUCCESS.getCode());
        rl.setMessage(RCodeEnum.SUCCESS.getMessage());
        rl.setData(list);
        return rl;
    }
}
