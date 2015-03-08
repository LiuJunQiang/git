package com.privilege.dao;

import java.util.List;

import com.privilege.beans.Privilege;
import com.privilege.beans.Role;
import com.privilege.beans.Role_Privilege;
import com.privilege.beans.User;

public interface PrivilegeDao extends BaseDao<Privilege> {

	List<Privilege> getMenus(User user);

	List<Privilege> selectPrivileges(Role role);

	public void setRoles(Role_Privilege role_privilege);

	public List<Role> selectRoles(Privilege privilege);
	
	public void deleteRoles(Privilege privilege);
}
