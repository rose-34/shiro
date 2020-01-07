package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public interface RoleMapper {
	@Select("SELECT  perms FROM Role ")
	public List<Role> findPerms();

}
