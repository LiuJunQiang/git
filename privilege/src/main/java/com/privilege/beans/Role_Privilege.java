package com.privilege.beans;

import java.io.Serializable;

public class Role_Privilege implements Serializable {
	
	private Integer roleID;
	private Integer privilegeID;
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public Integer getPrivilegeID() {
		return privilegeID;
	}
	public void setPrivilegeID(Integer privilegeID) {
		this.privilegeID = privilegeID;
	}
}
