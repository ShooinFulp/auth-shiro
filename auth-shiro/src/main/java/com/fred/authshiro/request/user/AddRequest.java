package com.fred.authshiro.request.user;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/13 11:32
 */
@Data
public class AddRequest {
    private String username;
    private String password;
}
