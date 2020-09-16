package com.example.quickdev.base;

import com.github.pagehelper.PageInfo;
import lombok.Data;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/16 11:08
 */
@Data
public class RP<T> extends R {

    private PageInfo<T> data;

    public static <T> RP success(PageInfo<T> pageInfo) {
        RP rp = new RP();
        rp.setSuccess(true);
        rp.setCode(RCodeEnum.SUCCESS.getCode());
        rp.setMessage(RCodeEnum.SUCCESS.getMessage());
        rp.setData(pageInfo);
        return rp;
    }
}
