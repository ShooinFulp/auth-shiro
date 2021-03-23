package com.fred.authshiro.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Fred
 * @date 2021/3/23 10:32
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class ShiroConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm());
        manager.setSessionManager(sessionManager());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        factoryBean.setFilterChainDefinitionMap(getFilterChainDefinitionMap());
        return factoryBean;
    }

    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager manager = new DefaultWebSessionManager();
        manager.setSessionDAO(sessionDAO());
        return manager;
    }

    @Bean
    public SessionDAO sessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisProperties.getHost());
        redisManager.setPort(redisProperties.getPort());
        redisManager.setPassword(redisProperties.getPassword());
        redisManager.setTimeout((int) redisProperties.getTimeout().toMillis());
        return redisManager;
    }

    private Map<String, String> getFilterChainDefinitionMap() {
        Map<String, String> filterChainDefinition = new LinkedHashMap<>();
        filterChainDefinition.put("/user/login", DefaultFilter.anon.name());
        filterChainDefinition.put("/**", DefaultFilter.authc.name());
        return filterChainDefinition;
    }
}
