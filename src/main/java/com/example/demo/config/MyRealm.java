package com.example.demo.config;

import java.util.List;

import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

//自定义
public class MyRealm extends AuthorizingRealm {
	@Autowired
	  private UserService userservice;
	private  RoleService roleservice;
   // 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("授权");
		// 權限設置
	
		SimpleAuthorizationInfo  info=new SimpleAuthorizationInfo();
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
		 User user=(User) subject.getPrincipal(); 
		 User dnuser=userservice.findUserName(user.getUsername());
		 System.out.println(dnuser.getPerms());
		 info.addStringPermission(dnuser.getPerms());
		return info;
	}
//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("认证");
		//对用户认证
		
		/*
		 * String name="cxk"; String password="123";
		 */

		 UsernamePasswordToken  token=(UsernamePasswordToken)arg0;
		 User user=userservice.findUserName(token.getUsername());
		if(user==null) {
			return null;  //UnknownAccountException
		}
		
		//判断密码
		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
		
	}

}
