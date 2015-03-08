package com.ssmtest.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	private Integer userID;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<Role>();
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
