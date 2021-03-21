package com.fred.authshiro.request.user;

import lombok.Data;

import java.util.List;

/**
 * 〈分配角色权限〉
 *
 * @author: Fred
 * @date: 2021/3/21 8:33 下午
 */
@Data
public class AllocRoleRequest {
    private Integer userId;
    private Integer[] roleIds;
}
