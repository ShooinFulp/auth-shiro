package com.fred.authshiro.request.menu;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/27 20:53
 */
@Data
public class AddRequest {
    private Integer parentId;
    private String title;
    private Integer sort;
    private String icon;
    private Boolean hidden;
}
