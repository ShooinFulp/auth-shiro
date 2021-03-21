package com.fred.authshiro.request.user;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/13 11:56
 */
@Data
public class UpdateRequest {
    private Integer id;

    private String username;

    private String password;
}
