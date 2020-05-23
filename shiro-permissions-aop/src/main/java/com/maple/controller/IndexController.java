package com.maple.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 根控制器
 *
 * @author maple
 * @version 1.0
 * @since 2020-05-14 17:19
 */
@RestController
public class IndexController {
    /**
     * 去掉aop依赖时 返回  {@link org.apache.shiro.authz.UnauthenticatedException} 异常
     * 加上aop依赖 去掉权限注解正常访问
     * {@link com.maple.config.ShiroConfig DefaultAdvisorAutoProxyCreator} 配置proxyTargetClass,usePrefix其中一个为true
     * 返回  {@link org.apache.shiro.authz.UnauthenticatedException} 异常
     * {@link com.maple.config.ShiroConfig #DefaultAdvisorAutoProxyCreator} 不配置或都配置为false时404异常 无法映射请求
     */
    @RequiresPermissions("admin")
    @GetMapping
    public String empty() {
        return "hello";
    }
}
