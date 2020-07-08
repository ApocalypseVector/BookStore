package com.example.shiro_test.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther Zoom
 * @Date 2020/7/6 at 11:05
 */
@Configuration
public class ShiroConfig {
    //    1.创建realm对象，是用于数据层的
    @Bean
    public userRealm Realm() {
        return new userRealm();
    }

    //    2.DefaultWebSecurityManager
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("Realm") userRealm Realm) {
        DefaultWebSecurityManager def = new DefaultWebSecurityManager();
//        关联userRealm
        def.setRealm(Realm);
        return def;
    }

    //    3.ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /*
         * anon:无需认证就可以访问
         * authc：必须认证才能访问
         * perms：拥有某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         * */
        Map<String, String> FilterHashMap = new LinkedHashMap<>();
        FilterHashMap.put("/user/*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(FilterHashMap);
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        return shiroFilterFactoryBean;
    }
}
