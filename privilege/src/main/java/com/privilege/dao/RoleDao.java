package com.privilege.dao;

import java.util.List;

import com.privilege.beans.Role;
import com.privilege.beans.Role_Privilege;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;

public interface RoleDao extends BaseDao<Role> {
	public void saveRelativity(Role_Privilege role_Privilege);

	public List<Role> selectRoles(User user);
	public void deletePrivileges(Role role);
	public void deleteUsers(Role role);

	public List<User> selectUsers(Role role);

	public void setUsers(User_Role user_role);
}
