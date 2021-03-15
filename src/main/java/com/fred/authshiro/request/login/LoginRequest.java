package com.fred.authshiro.request.login;

import lombok.Data;

/**
 * @author Fred
 * @date 2021/3/15 9:51
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
