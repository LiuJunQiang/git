package com.privilege.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.privilege.beans.Role;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;
import com.privilege.dao.UserDao;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
  public UserDaoImpl() {
	  super.setNs("com.privilege.beans.User");
  }

	@Override
	public User login(User user) {
		return super.getSqlSession().selectOne(super.getNs()+".login", user);
	}

	@Override
	public void setRole(User_Role user_role) {
		
		User user = new User();
		user.setId(user_role.getUserID());
		super.deleteRelativity(user);
		
		super.getSqlSession().insert(super.getNs()+".saveRelativity", user_role);
	}
}
