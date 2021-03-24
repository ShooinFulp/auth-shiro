package com.fred.authshiro.exception;

import com.fred.authshiro.enums.BusinessErrorCode;
import com.fred.authshiro.enums.SystemCode;
import com.fred.authshiro.response.base.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 10:06 下午
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(ShiroException.class)
    public ResultVo<String> shiroExceptionHandler(ShiroException e) {
        log.error("ShiroException  -->>  ", e);
        return ResultVo.error(BusinessErrorCode.USER_NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResultVo<String> businessExceptionHandler(BusinessException e, HttpServletRequest request) {
        log.error("BusinessException  Url -->>  {} \n" +
                "AppCode   -->>  {}", request.getRequestURI(), e.getAppCode());
        log.error("The error is below \n", e);
        return ResultVo.error(e.getAppCode());
    }

    @ExceptionHandler(Exception.class)
    public ResultVo<String> exceptionHandler(Exception e) {
        log.error("ErrorMsg  -->>   ", e);
        return ResultVo.error(SystemCode.SYSTEM_ERROR);
    }


}
