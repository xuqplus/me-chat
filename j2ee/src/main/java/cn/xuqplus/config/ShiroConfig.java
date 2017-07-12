package cn.xuqplus.config;

import cn.xuqplus.shiro.MyAuthorizingRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qqx on 2017/7/8.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        /**
         * 登录页面
         */
        factoryBean.setLoginUrl("/public/html/login.html");
        /**
         * 过滤规则
         */
        Map definitions = new HashMap();
        definitions.put("/api/public/**", "anon");
        definitions.put("/public/**", "anon");
        definitions.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(definitions);
        /**
         * 安全管理器
         */
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }

    @Bean//(name = "securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    @Bean//(name = "realm")
    public Realm realm() {
        return new MyAuthorizingRealm();
    }
}
