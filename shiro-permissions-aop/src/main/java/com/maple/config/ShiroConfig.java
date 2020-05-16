package com.maple.config;

import com.maple.entity.MyRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro 配置
 *
 * @author maple
 * @version 1.0
 * @since 2020-05-14 17:18
 */
@Configuration
public class ShiroConfig {
    @Bean
    public Realm myRealm() {
        return new MyRealm();
    }

    /**
     * 拦截url配置
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**", "anon");
        return chainDefinition;
    }

    /**
     * 由于多重代理的原因 如果userPrefix和proxyTargetClass都为false会导致 aop和shiro权限注解不兼容 资源报错404
     * 因此两个属性至少需要其中一个属性为true才可以
     * // 猜测原因: （尚未验证）
     * (userPrefix将实际的bean名称进行了变更因此aop和shiro取到的不是同一个对象 而proxyTargetClass基于类代理不同的代理方式也能解决代理冲突)
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(false);
        return defaultAdvisorAutoProxyCreator;
    }
}
