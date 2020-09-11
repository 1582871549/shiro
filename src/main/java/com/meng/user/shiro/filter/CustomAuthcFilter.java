package com.meng.user.shiro.filter;

import com.meng.user.common.util.JwtHelper;
import com.meng.user.repository.entity.UserDO;
import com.meng.user.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomAuthcFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;


    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        if (isAuthenticated()) {
            return true;
        }

        // 未认证
        String token = getToken(request);

        if (StringUtils.isNotBlank(token)) {

            String username = String.valueOf(getSubject().getPrincipals().getPrimaryPrincipal());

            UserDO userDO = userService.getUserByUsername(username);

            boolean verify = JwtHelper.verify(token, userDO.getPassword());

            if (verify) {
                // 验证成功
                return true;
            }
        }

        WebUtils.issueRedirect(request, response, "login");

        return false;
    }


    protected String getToken(ServletRequest servletRequest) {

        HttpServletRequest request = WebUtils.toHttp(servletRequest);

        String token = request.getHeader("token");

        return token;
    }

    protected boolean isAuthenticated() {
        return getSubject().isAuthenticated();
    }

    protected Subject getSubject() {
        return SecurityUtils.getSubject();
    }
}
