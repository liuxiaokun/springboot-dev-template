package com.example.quickdev.exception;

import com.example.quickdev.base.RO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 13:42
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public RO exceptionHandler(Exception e) {
        log.error("未知异常", e);
        return RO.fail(e.getMessage());
    }

    @ExceptionHandler(value = BizException.class)
    public RO bizException(BizException e) {
        log.error("业务异常", e);
        return RO.fail(e.getMessage());
    }
}