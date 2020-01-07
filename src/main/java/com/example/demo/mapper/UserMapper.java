package com.example.demo.mapper;

import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

public interface UserMapper {
	@Select("SELECT *FROM user where username=#{value}")
	public User findUserName(String  username);

}
