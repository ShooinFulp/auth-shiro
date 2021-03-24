package com.fred.authshiro.controller;

import com.fred.authshiro.constant.SystemConst;
import com.fred.authshiro.request.login.LoginRequest;
import com.fred.authshiro.response.base.ResultVo;
import com.fred.authshiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fred
 * @date 2021/3/15 9:48
 */
@RestController
@RequestMapping(SystemConst.LOGIN_PATH_PREFIX)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(SystemConst.LOGIN_PATH_SUFFIX)
    public ResultVo doLogin(@RequestBody LoginRequest loginRequest) {
        return loginService.doLogin(loginRequest);
    }
}
