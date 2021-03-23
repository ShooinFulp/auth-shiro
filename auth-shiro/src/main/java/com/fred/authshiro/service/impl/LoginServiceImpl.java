package com.fred.authshiro.service.impl;

import com.fred.authshiro.mapper.TbUserMapper;
import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.request.login.LoginRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
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
        SecurityUtils.getSubject()
                .login(new UsernamePasswordToken(loginRequest.getUsername(), loginRequest.getPassword()));
        return ResultVo.success("admin-token");
    }
}
