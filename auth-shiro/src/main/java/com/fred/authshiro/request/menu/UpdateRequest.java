package com.fred.authshiro.request.menu;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/27 21:02
 */
@Data
public class UpdateRequest {
    private Integer id;
    private Integer parent_id;
    private String title;
    private Integer sort;
    private String icon;
    private Boolean hidden;
}
