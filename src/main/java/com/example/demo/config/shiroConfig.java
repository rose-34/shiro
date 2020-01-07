package com.example.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class shiroConfig {
	 //创建爱你shiroFliterFactoryBean
	@Bean
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		// 设置安全管理爱
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 添加shiro过滤器
		// anon 无需认证 (不要登录) authc 需要认真 user使用rememberMe的才可以
		// perms 该资源必须得到资源权限访问 role 德奥角色权限
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		
		filterChainDefinitionMap.put("/add", "perms[user:add]");//授權攔截 跳转到未授权页面
		filterChainDefinitionMap.put("/update", "perms[user:update]");//授權攔截 跳转到未授权页面
		
		filterChainDefinitionMap.put("/login", "anon");

		filterChainDefinitionMap.put("/*", "authc");
		filterChainDefinitionMap.put("/*", "authc");
		// 主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
		shiroFilterFactoryBean.setLoginUrl("/tologin");
		
		
	   //未授权页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthor");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilterFactoryBean;

	}
	
	
	//创建webSecurityManager
	@Bean(name="securityManager")
    public DefaultWebSecurityManager getsecurityManager(@Qualifier("Realm")MyRealm  Realm ) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(Realm);
        return securityManager;
    }

	
	
	//Realm
	@Bean(name="Realm")
	public  MyRealm getrealm() {
		return new MyRealm();
		
	}
	
	// html 设置
	@Bean(name = "shiroDialect")
	 
    public ShiroDialect shiroDialect(){
 
    return new ShiroDialect();
	}
 

	

}
