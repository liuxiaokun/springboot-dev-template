package com.example.quickdev.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 13:42
 */
@Data
public class BizException extends Exception {

    public BizException(String message) {
        super(message);
    }
}
