package com.meng.user.shiro.filter;

import com.meng.user.common.util.JwtHelper;
import com.meng.user.repository.entity.UserDO;
import com.meng.user.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CustomAuthcFilter extends FormAuthenticationFilter {

    private static final String TOKEN = "token";

    @Autowired
    private UserService userService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 是否携带token
        if (isCarryToken(request)) {
            return verifyToken(request, response);
        } else {
            if (isLoginRequest(request, response)) {
                // 是登录请求, 放过, 允许请求登录接口
                return true;
            } else {
                // 非登录请求, 重定向到登录页面
                saveRequestAndRedirectToLogin(request, response);
                return false;
            }
        }
    }

    /**
     * 用户是否携带token
     *
     * @return <code>true</code> 携带
     */
    private boolean isCarryToken(ServletRequest request) {
        String token = getToken(request);
        return StringUtils.isNotBlank(token);
    }

    private boolean verifyToken(ServletRequest request, ServletResponse response) throws Exception {
        String username = getPrincipal();
        UserDO userDO = getUser(username);
        String token = getToken(request);

        if (userDO != null && JwtHelper.verify(token, userDO.getPassword())) {
            return onLoginSuccess(request, response);
        } else {
            return onLoginFailure(request, response);
        }
    }

    private String getToken(ServletRequest request) {
        return WebUtils.toHttp(request).getHeader(TOKEN);
    }

    private String getPrincipal() {
        Subject subject = getSubject();
        PrincipalCollection principals = subject.getPrincipals();

        if (principals == null || principals.isEmpty()) {
            return "";
        }
        return String.valueOf(principals.getPrimaryPrincipal());
    }

    private Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    private UserDO getUser(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        return userService.getUserByUsername(username);
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
    private boolean onLoginFailure(ServletRequest request, ServletResponse response) throws IOException {
        redirectToLogin(request, response);
        return false;
    }

}
