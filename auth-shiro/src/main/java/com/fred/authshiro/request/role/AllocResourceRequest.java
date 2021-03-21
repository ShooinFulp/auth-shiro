package com.fred.authshiro.request.role;

import lombok.Data;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/21 11:20 下午
 */
@Data
public class AllocResourceRequest {
    private Integer roleId;
    private Integer[] resourceIds;
}
