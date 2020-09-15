package com.meng.user.shiro.filter;

import com.meng.user.common.util.JwtHelper;
import com.meng.user.repository.entity.UserDO;
import com.meng.user.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomAuthcFilter extends FormAuthenticationFilter {

    @Autowired
    private UserService userService;

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

        String token = getToken(request);

        // token为null, 允许访问登录接口使用账号密码登录
        if (token == null) {
            return true;
        } else {
            return verify(token, request, response);
        }
    }

    private String getToken(ServletRequest servletRequest) {

        HttpServletRequest request = WebUtils.toHttp(servletRequest);

        return request.getHeader("token");
    }

    private boolean verify(String token, ServletRequest request, ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);
        PrincipalCollection principals = subject.getPrincipals();

        if (principals == null || principals.isEmpty()) {
            return true;
        }

        String username = String.valueOf(principals.getPrimaryPrincipal());

        if (StringUtils.isBlank(username)) {
            return true;
        }

        UserDO userDO = userService.getUserByUsername(username);

        if (userDO != null && JwtHelper.verify(token, userDO.getPassword())) {
            return onLoginSuccess(request, response);
        } else {
            return onLoginFailure(request, response);
        }
    }

    /**
     * 登录成功直接处理重定向，阻止链式拦截器的继续
     */
    private boolean onLoginSuccess(ServletRequest request, ServletResponse response) throws Exception {
        issueSuccessRedirect(request, response);
        return false;
    }

    /**
     * 登录失败，让请求继续返回登录页面:
     */
    private boolean onLoginFailure(ServletRequest request, ServletResponse response) {
        return true;
    }



}
