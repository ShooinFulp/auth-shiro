package com.fred.authshiro.shiro;

import com.fred.authshiro.enums.BusinessErrorCode;
import com.fred.authshiro.exception.BusinessException;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Fred
 * @date 2021/3/24 19:48
 */

public class LoginFilter extends AccessControlFilter {

    private static final String AUTH_TOKEN = "token";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (isLoginRequest(request, response)) {
            return true;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(AUTH_TOKEN);
        System.out.println(token);
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        throw BusinessException.create(BusinessErrorCode.TOKEN_IS_NULL);
    }
}
