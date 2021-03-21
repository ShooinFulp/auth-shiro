package com.fred.authshiro.service.impl;

import com.fred.authshiro.request.login.LoginRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * @author Fred
 * @date 2021/3/15 9:52
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public ResultVo<String> doLogin(LoginRequest loginRequest) {
        return ResultVo.success("admin-token");
    }
}
