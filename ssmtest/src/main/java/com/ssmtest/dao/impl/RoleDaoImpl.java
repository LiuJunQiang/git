package com.ssmtest.dao.impl;


import org.springframework.stereotype.Repository;

import com.ssmtest.beans.Role;
import com.ssmtest.dao.RoleDao;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	public RoleDaoImpl() {
		super.setNs("com.ssmtest.beans.Role");
	}
}
