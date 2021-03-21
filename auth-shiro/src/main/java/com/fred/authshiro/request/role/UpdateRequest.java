package com.fred.authshiro.request.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 9:57 下午
 */
@Data
public class UpdateRequest {
    @NotNull
    private Integer id;
    @NotEmpty
    private String roleName;
}
