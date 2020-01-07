package com.example.demo.controller;

import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@Controller
public class HelloController {
	
	@Autowired
	  private UserService userservice;
	
	@RequestMapping("/hello")

	public String hello() {
		return "Hello world!";
	}

	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {

		model.addAttribute("name", "cxk");
		return "test.html";
	}

	@RequestMapping("/add")
	public String add(Model model) {

		return "user/add.html";
	}

	@RequestMapping("/update")
	public String update(Model model) {

		return "user/update.html";
	}

//login
	@RequestMapping("/tologin")
	public String tologin(Model model) {

		return "login.html";
	}
	//login
		@RequestMapping("/login")
		public String login(String name, String password,Model model) {
			
			//shiro 使用
			//1 使用subject编写认证
			org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();

			//2封装数据用户
			UsernamePasswordToken token=new UsernamePasswordToken(name,password);
			//3执行登录方法
			try {
				subject.login(token);
				//成功登录
				return "test.html";
			} catch (UnknownAccountException e) {
				// TODO: handle exception
				model.addAttribute("msg", "用户不存在");
				return "login.html";
			}
			
			catch (IncorrectCredentialsException e) {
				// TODO: handle exception
				model.addAttribute("msg", "用户密码错误");
				return "login.html";
			}

			
		}
		
		//unauthor 未授权页面
		@RequestMapping("/unauthor")
		public String unauthor(Model model) {

			return "unauthor.html";
		} 
		


}
