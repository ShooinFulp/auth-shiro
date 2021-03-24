package com.fred.authshiro.enums;

import com.fred.authshiro.constant.SystemConst;

/**
 * @author Fred
 * @date 2021/3/24 16:38
 * @description 10000-20000
 */
public enum SystemCode implements AppCode {
    SYSTEM_ERROR(10000, "系统异常，请联系管理员!"),
    SUCCESSFUL(20000, "成功!"),
    ;

    SystemCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
