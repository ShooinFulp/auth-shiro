package com.fred.authshiro.enums;

/**
 * @author Fred
 * @date 2021/3/23 21:24
 * @description 10000-20000
 */
public enum SystemErrorCode implements AppCode<Integer> {
    USER_NOT_FOUND(10000,"用户不存在!");

    SystemErrorCode(Integer code, String message) {
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
