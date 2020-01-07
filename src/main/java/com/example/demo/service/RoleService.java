package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;

@Service
public class RoleService {
	@Autowired
    private RoleMapper rolemapper;
	public List<Role> findPerms() {
		return rolemapper.findPerms();
	}

}
