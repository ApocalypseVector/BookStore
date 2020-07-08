package com.example.shiro_test.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Auther Zoom
 * @Date 2020/7/6 at 11:10
 */

public class userRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权操作=>doGetAuthorizationInfo");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证操作=>doGetAuthenticationInfo");
        /*
         * 用户名密码模拟
         * */
        String username = "root";
        String password = "123";
        UsernamePasswordToken Utoken = (UsernamePasswordToken) authenticationToken;
        if (!Utoken.getUsername().equals(username)) {
            return null;
        }
        return new SimpleAuthenticationInfo("", password, "");
    }
}
