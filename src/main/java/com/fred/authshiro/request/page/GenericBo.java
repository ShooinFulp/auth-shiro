package com.fred.authshiro.request.page;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/13 14:18
 */
@Data
public class GenericBo<T> extends PageSize {
    private T param;
}
