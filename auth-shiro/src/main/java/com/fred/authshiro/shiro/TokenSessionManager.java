package com.fred.authshiro.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Fred
 * @date 2021/3/25 11:41
 * @description 前后端分离后跨域请求每次都是一次新的会话, 所以不能基于默认JSession_id会话方式, 这里使用自定义Header:token方式
 */
public class TokenSessionManager extends DefaultWebSessionManager {

    private static final String TOKEN = "token";

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        String token = httpServletRequest.getHeader(TOKEN);
        return Optional.<Serializable>ofNullable(token).orElse(super.getSessionId(request, response));
    }
}
