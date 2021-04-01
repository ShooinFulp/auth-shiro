package com.fred.authshiro.request.role;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/30 17:38
 */
@Data
public class AllocMenuRequest {
    private Integer roleId;
    private Integer[] MenuIds;
}
