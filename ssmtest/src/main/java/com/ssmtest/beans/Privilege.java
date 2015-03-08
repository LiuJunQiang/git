package com.ssmtest.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Privilege implements Serializable{
	private Integer privilegeID;
	private String privilegeName;
	private String url;
	private String icon;
	private Integer orderNumber;
	private Set<Role> roles = new HashSet<Role>();
	
	
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getPrivilegeID() {
		return privilegeID;
	}
	public void setPrivilegeID(Integer privilegeID) {
		this.privilegeID = privilegeID;
	}
	
	
}
