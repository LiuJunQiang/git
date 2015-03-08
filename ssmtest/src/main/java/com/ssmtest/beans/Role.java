package com.ssmtest.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{
	private Integer roleID;
	private String roleName;
	private String roleDesc;
	private Set<User> users = new HashSet<User>();
	private Set<Privilege> privileges =  new HashSet<Privilege>();
	
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
}
