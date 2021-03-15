package com.fred.authshiro.controller;

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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/doLogin")
    public ResultVo doLogin(@RequestBody LoginRequest loginRequest) {
        return loginService.doLogin(loginRequest);
    }
}
