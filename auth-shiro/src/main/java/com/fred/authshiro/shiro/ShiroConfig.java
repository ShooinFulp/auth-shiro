package com.fred.authshiro.shiro;

import com.fred.authshiro.constant.SystemConst;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Fred
 * @date 2021/3/23 10:32
 */
@Configuration
public class ShiroConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.password}")
    private String password;

    private static final String LOGIN_URL = SystemConst.LOGIN_PATH_PREFIX + SystemConst.LOGIN_PATH_SUFFIX;

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm());
        manager.setSessionManager(sessionManager());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager());
        factoryBean.setFilterChainDefinitionMap(getFilterChainDefinitionMap());
        factoryBean.setFilters(new HashMap<String, Filter>(1) {{
            put("auth", loginFilter());
        }});
        factoryBean.setLoginUrl(LOGIN_URL);
        return factoryBean;
    }

    @Bean
    public LoginFilter loginFilter() {
        return new LoginFilter();
    }

    @Bean
    public SessionManager sessionManager() {
        TokenSessionManager manager = new TokenSessionManager();
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
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setPassword(password);
        redisManager.setTimeout(timeout);
        return redisManager;
    }

    private Map<String, String> getFilterChainDefinitionMap() {
        Map<String, String> filterChainDefinition = new LinkedHashMap<>();
        filterChainDefinition.put("/login/doLogin", DefaultFilter.anon.name());
        filterChainDefinition.put("/**", "auth");
        return filterChainDefinition;
    }
}
