package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class Springboot1Application {

	/*
	 * @RequestMapping("/hellow") public String hello(){
	 * return"Hello SprinsfsdfsdgBoot!"; }
	 */
	 
	 
	public static void main(String[] args) {
		SpringApplication.run(Springboot1Application.class, args);
	}

}
