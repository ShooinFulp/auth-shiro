package com.fred.authshiro.exception;

import com.fred.authshiro.response.base.ResultVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 10:06 下午
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultVo<String> exceptionHandler(Exception e) {
        return ResultVo.error(e.getMessage());
    }
}
