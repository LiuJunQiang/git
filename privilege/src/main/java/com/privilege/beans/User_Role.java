package com.privilege.beans;

import java.io.Serializable;

public class User_Role implements Serializable{
	private Integer userID;
	private Integer roleID;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
}
