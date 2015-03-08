package com.privilege.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.privilege.beans.Role;
import com.privilege.beans.Role_Privilege;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;
import com.privilege.dao.RoleDao;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	public RoleDaoImpl() {
		super.setNs("com.privilege.beans.Role");
	}

	@Override
	public void saveRelativity(Role_Privilege role_Privilege) {
		super.getSqlSession().insert(super.getNs()+".saveRelativity", role_Privilege);
	}

	@Override
	public List<Role> selectRoles(User user) {
		return super.getSqlSession().selectList(super.getNs()+".selectRoles", user);
	}
	
	@Override
	public void deleteRelativity(Role entity) {
		
		this.deletePrivileges(entity);
		this.deleteUsers(entity);
	}
	
	@Override
	public void deletePrivileges(Role role) {
		super.getSqlSession().delete(super.getNs()+".deletePrivileges", role);
		
	}

	@Override
	public void deleteUsers(Role role) {
		super.getSqlSession().delete(super.getNs()+".deleteUsers", role);
		
	}

	@Override
	public List<User> selectUsers(Role role) {
		return super.getSqlSession().selectList(super.getNs()+".selectUsers", role);
	}

	@Override
	public void setUsers(User_Role user_role) {
		super.getSqlSession().delete(super.getNs()+".setUser", user_role);
	}
}
