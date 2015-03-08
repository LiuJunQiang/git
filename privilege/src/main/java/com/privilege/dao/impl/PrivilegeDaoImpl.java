package com.privilege.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.privilege.beans.Privilege;
import com.privilege.beans.Role;
import com.privilege.beans.Role_Privilege;
import com.privilege.beans.User;
import com.privilege.dao.PrivilegeDao;

@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements
		PrivilegeDao {
	public PrivilegeDaoImpl() {
		super.setNs("com.privilege.beans.Privilege");
	}

	@Override
	public List<Privilege> getMenus(User user) {
		return super.getSqlSession().selectList(super.getNs()+".getMenus", user);
	}

	@Override
	public List<Privilege> selectPrivileges(Role role) {
		return super.getSqlSession().selectList(super.getNs()+".selectPrivileges", role);
	}

	@Override
	public void deleteRoles(Privilege entity) {
		super.getSqlSession().delete(super.getNs()+".deleteRoles",entity);
	}

	@Override
	public void setRoles(Role_Privilege role_privilege) {
		super.getSqlSession().insert(super.getNs()+".setRoles", role_privilege);
	}

	@Override
	public List<Role> selectRoles(Privilege privilege) {
		return super.getSqlSession().selectList(super.getNs()+".selectRoles", privilege);
	}
}
