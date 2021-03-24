package com.fred.authshiro.response.base;

import com.fred.authshiro.constant.SystemConst;
import com.fred.authshiro.enums.AppCode;
import com.fred.authshiro.enums.SystemCode;
import lombok.Data;

@Data
public class ResultVo<T> {

    /**
     * 成功/失败
     */
    private Boolean status;

    private Integer code;

    private String message;

    private String errorMsg;

    private T data;

    /**
     * 默认无参构造器返回成功结果集
     */
    public ResultVo() {
        super();
        this.status = true;
        this.message = SystemConst.successMessage;
    }

    public ResultVo(Boolean status) {
        super();
        this.status = status;
    }

    public ResultVo(Boolean status, String message, Integer code, T data) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static ResultVo status(Boolean status) {
        return new ResultVo(status);
    }

    public static ResultVo success() {
        return new ResultVo(true, SystemCode.SUCCESSFUL.getMessage(), SystemCode.SUCCESSFUL.getCode(), null);
    }

    public static ResultVo success(Object data) {
        return new ResultVo(true, SystemCode.SUCCESSFUL.getMessage(), SystemCode.SUCCESSFUL.getCode(), data);
    }

    public static ResultVo success(Object data, String message) {
        return new ResultVo(true, message, SystemCode.SUCCESSFUL.getCode(), data);
    }

    public static ResultVo success(Integer code, Object data, String message) {
        return new ResultVo(true, message, code, data);
    }

    public static ResultVo error() {
        return new ResultVo(false, SystemCode.SYSTEM_ERROR.getMessage(), SystemCode.SYSTEM_ERROR.getCode(), null);
    }

    public static ResultVo error(String message) {
        return new ResultVo(false, message, SystemCode.SYSTEM_ERROR.getCode(), null);
    }

    public static ResultVo error(AppCode appCode) {
        return new ResultVo(false, appCode.getMessage(), appCode.getCode(), null);
    }

    public static ResultVo error(Integer code, String message) {
        return new ResultVo(false, message, code, null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultVo{");
        sb.append("status=").append(status);
        sb.append(", code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", errorMsg='").append(errorMsg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}