package com.meng.user.common.config;

import com.meng.user.common.model.ShiroProperties;
import com.meng.user.shiro.filter.CustomAuthcFilter;
import com.meng.user.shiro.permission.CustomRolePermissionResolver;
import com.meng.user.shiro.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 大橙子
 * @date 2019/3/25
 * @since 1.0.0
 */
// @Order(1)
@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是会报错的，
     * 因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * <p>
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     * <p>
     * hiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。
     * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                         CustomAuthcFilter customAuthcFilter) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        /*
         * 配置自定义过滤器
         *
         * 如果自定义filter导入异常, 直接new放入即可
         */
        Map<String, Filter> filtersMap = bean.getFilters();
        filtersMap.put("custom", customAuthcFilter);
        // filtersMap.put("kaptcha", kaptchaFilter);
        bean.setFilters(filtersMap);


        /*
         * 配置用户登陆页面
         * 配置成功跳转路径
         * 配置未经授权页面
         */
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        // bean.setUnauthorizedUrl("/error/403_error.html");
        bean.setUnauthorizedUrl("/403");

        /*
         * 配置自定义拦截器
         *
         * authc:所有url都必须认证通过才可以访问
         * anon:所有url都都可以匿名访问
         * DefaultFilter
         */
        Map<String, String> interceptsMap = new LinkedHashMap<>();
        interceptsMap.put("/user/**", "user");
        interceptsMap.put("/role/**", "perms");
        interceptsMap.put("/static/**", "anon");
        interceptsMap.put("/**", "custom");

        bean.setFilterChainDefinitionMap(interceptsMap);
        return bean;
    }

    @Bean("customFormAuthenticationFilter")
    public CustomAuthcFilter customFormAuthenticationFilter() {
        return new CustomAuthcFilter();
    }

    /**
     * 权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。
     *
     * @param userRealm      自定义用户域
     * @return securityManager
     */
    @Bean(name = "securityManager")
    public SecurityManager securityManager(UserRealm userRealm,
                                           RememberMeManager rememberMeManager,
                                           ModularRealmAuthorizer modularRealmAuthorizer) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setAuthorizer(modularRealmAuthorizer);
        securityManager.setRememberMeManager(rememberMeManager);
        return securityManager;
    }

    /**
     * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
     * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
     * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 用户认证类
     *
     * @return userRealm
     */
    @Bean(name = "userRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public UserRealm userRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userRealm;
    }

    /**
     * HashedCredentialsMatcher，这个类是为了对密码进行编码的，防止密码在数据库里明码保存，
     * 这个类也负责在登陆时form中输入的密码进行编码。
     *
     * @return hashedCredentialsMatcher
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(ShiroProperties shiroProperties) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(shiroProperties.getPassword().getHashAlgorithm());
        hashedCredentialsMatcher.setHashIterations(shiroProperties.getPassword().getHashIterations());
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(shiroProperties.getPassword().isStoredCredentialsHexEncoded());
        return hashedCredentialsMatcher;
    }

    /**
     * 权限 解析器
     *
     * 根据权限操作符, 创建不同的权限实例
     *
     * @return 权限 解析器
     */
    @Bean(name = "modularRealmAuthorizer")
    public ModularRealmAuthorizer modularRealmAuthorizer(CustomRolePermissionResolver customRolePermissionResolver) {
        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        authorizer.setRolePermissionResolver(customRolePermissionResolver);
        return authorizer;
    }

    /**
     * 角色-权限 解析器
     *
     * 根据角色名称获取对应的权限列表, 对相应的权限进行缓存管理
     *
     * @return 角色-权限 解析器
     */
    @Bean(name = "customRolePermissionResolver")
    public CustomRolePermissionResolver customRolePermissionResolver() {
        return new CustomRolePermissionResolver();
    }

    /**
     * cookie管理对象;
     *
     * @return rememberMeManager
     */
    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) {
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(rememberMeCookie);
        return manager;
    }

    /**
     * rememberMe 是cookie的名称，对应前端的checkbox的name = rememberMe
     * 记住我cookie生效时间30天 ,单位秒
     *
     * @return rememberMeCookie
     */
    @Bean(name = "rememberMeCookie")
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie();
        cookie.setName("rememberMe");
        cookie.setMaxAge(259200);
        return cookie;
    }

    /**
     * session管理
     *
     * @param scheduler session校验程序
     * @return sessionManager
     */
    @Bean(name = "sessionManager")
    public DefaultWebSessionManager defaultWebSessionManager(ExecutorServiceSessionValidationScheduler scheduler) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(18000000);
        // url中是否显示session Id
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        // 删除失效的session
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationInterval(18000000);
        sessionManager.setSessionValidationScheduler(scheduler);
        //设置SessionIdCookie 导致认证不成功，不从新设置新的cookie,从sessionManager获取sessionIdCookie
        //sessionManager.setSessionIdCookie(simpleIdCookie());
        sessionManager.getSessionIdCookie().setName("session-dudu-id");
        sessionManager.getSessionIdCookie().setPath("/");
        sessionManager.getSessionIdCookie().setMaxAge(60 * 60 * 24 * 7);
        return sessionManager;
    }

    /**
     * session校验程序
     *
     * @return executorServiceSessionValidationScheduler
     */
    @Bean(name = "executorServiceSessionValidationScheduler")
    public ExecutorServiceSessionValidationScheduler executorServiceSessionValidationScheduler() {
        ExecutorServiceSessionValidationScheduler scheduler = new ExecutorServiceSessionValidationScheduler();
        scheduler.setInterval(900000);
        return scheduler;
    }

    /**
     * 开启aop自动代理 与authorizationAttributeSourceAdvisor搭配使用
     *
     * @return defaultAdvisorAutoProxyCreator
     */
    @Bean(name = "defaultAdvisorAutoProxyCreator")
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    /**
     * 开启shiro aop注解支持. 使用代理方式
     *
     * @return authorizationAttributeSourceAdvisor
     */
    @Bean(name = "authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager);
        return aasa;
    }

}
