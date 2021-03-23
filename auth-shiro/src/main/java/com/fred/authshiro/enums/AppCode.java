package com.fred.authshiro.enums;

/**
 * @author Fred
 * @date 2021/3/23 21:23
 */
public interface AppCode<T> {
    String getMessage();

    T getCode();
}
