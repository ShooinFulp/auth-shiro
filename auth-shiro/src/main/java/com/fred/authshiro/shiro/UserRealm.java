package com.fred.authshiro.shiro;

import com.fred.authshiro.enums.BusinessErrorCode;
import com.fred.authshiro.exception.BusinessException;
import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author Fred
 * @date 2021/3/23 10:41
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        TbUser user = userService.findUserByUsername(usernamePasswordToken.getUsername());
        user = Optional.ofNullable(user).orElseThrow(() -> BusinessException.create(BusinessErrorCode.USER_NOT_FOUND));
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo----");
        return null;
    }
}
