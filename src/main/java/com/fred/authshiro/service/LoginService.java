package com.fred.authshiro.service;

import com.fred.authshiro.request.login.LoginRequest;
import com.fred.authshiro.response.base.ResultVo;

/**
 * @author Fred
 * @date 2021/3/15 9:49
 */
public interface LoginService {
    ResultVo<String> doLogin(LoginRequest loginRequest);
}
