package com.fred.authshiro.exception;

import com.fred.authshiro.enums.AppCode;
import lombok.NonNull;
import org.springframework.util.StringUtils;

/**
 * @author Fred
 * @date 2021/3/23 21:16
 */
public class BusinessException extends RuntimeException {

    private AppCode appCode;

    private BusinessException(String msg, AppCode appCode) {
        super(msg);
        this.appCode = appCode;
    }

    public AppCode getAppCode() {
        return this.appCode;
    }

    private static BusinessException of(String message, AppCode appCode) {
        return new BusinessException(message, appCode);
    }

    public static BusinessException create(@NonNull AppCode appCode) {
        return BusinessException.of(appCode.getMessage(), appCode);
    }

    public static BusinessException create(@NonNull AppCode appCode, String errorMessage) {
        if (StringUtils.hasText(errorMessage)) {
            return BusinessException.of(appCode.getMessage(), appCode);
        }
        return BusinessException.of(errorMessage, appCode);
    }
}
