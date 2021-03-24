package com.fred.authshiro.enums;

import lombok.ToString;

/**
 * @author Fred
 * @date 2021/3/23 21:24
 * @description 20001-30000
 */
@ToString
public enum BusinessErrorCode implements AppCode {
    USER_NOT_FOUND(20001, "用户名或密码错误!"),
    TOKEN_IS_NULL(20002, "请登录!");

    BusinessErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private String message;

    private Integer code;

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}
