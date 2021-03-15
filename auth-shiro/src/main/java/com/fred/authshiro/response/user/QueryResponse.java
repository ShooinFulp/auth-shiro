package com.fred.authshiro.response.user;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/13 14:40
 */
@Data
public class QueryResponse {
    private Integer id;

    private String username;

    private String password;
}
