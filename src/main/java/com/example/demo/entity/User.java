package com.example.demo.entity;

/**
 * @author pengshukun
 *
 */
public class User {
 private  int id ;
  private String username;
  private String perms;
  public String getPerms() {
	return perms;
}
public void setPerms(String perms) {
	this.perms = perms;
}
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  
  
}
