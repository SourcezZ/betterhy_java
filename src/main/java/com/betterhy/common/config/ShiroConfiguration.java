package com.betterhy.common.config;

import com.betterhy.common.filter.UrlPathMatchingFilter;
import com.betterhy.common.secure.OaRealm;
import com.google.common.collect.Maps;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置类
 *
 * @author Source
 * @date 2020-07-06 11:29
 **/
@Configuration
public class ShiroConfiguration {
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String > filterChainDefinitionMap = new LinkedHashMap<>();
        Map<String, Filter> customizedFilter = Maps.newHashMapWithExpectedSize(1);

        // 设置自定义过滤器名称为 url
        customizedFilter.put("url", getUrlPathMatchingFilter());

        // 对管理接口的访问启用自定义拦截（url 规则），即执行 URLPathMatchingFilter 中定义的过滤方法
        // anon-开放  url-自定义的名为url的规则
        filterChainDefinitionMap.put("/api/login", "anon");
        filterChainDefinitionMap.put("/api/**", "url");
        // 启用自定义过滤器
        shiroFilterFactoryBean.setFilters(customizedFilter);
        // 拦截
        filterChainDefinitionMap.put("/api/authentication", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getOaRealm());
        return securityManager;
    }

    @Bean
    public OaRealm getOaRealm() {
        OaRealm oaRealm = new OaRealm();
        oaRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return oaRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return hashedCredentialsMatcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    public UrlPathMatchingFilter getUrlPathMatchingFilter() {
        return new UrlPathMatchingFilter();
    }

}