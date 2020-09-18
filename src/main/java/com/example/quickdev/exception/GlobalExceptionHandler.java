package com.example.quickdev.exception;

import com.example.quickdev.base.RO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @date 2020/9/14 13:42
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RO exceptionHandler(Exception e) {
        log.error("未知异常", e);
        return RO.fail("系统异常，请稍后重试！");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public RO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("参数校验异常", e);
        return RO.paramsCheckFail(String.join(";", e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())));
    }

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public RO bizException(BizException e) {
        log.error("业务异常", e);
        return RO.fail(e.getMessage());
    }
}