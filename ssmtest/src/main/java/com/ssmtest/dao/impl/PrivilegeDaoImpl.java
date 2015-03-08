package com.ssmtest.dao.impl;


import org.springframework.stereotype.Repository;

import com.ssmtest.beans.Privilege;
import com.ssmtest.dao.PrivilegeDao;

@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements
		PrivilegeDao {
	public PrivilegeDaoImpl() {
		super.setNs("com.ssmtest.beans.Privilege");
	}
}
