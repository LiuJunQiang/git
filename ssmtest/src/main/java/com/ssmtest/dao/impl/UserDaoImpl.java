package com.ssmtest.dao.impl;


import org.springframework.stereotype.Repository;

import com.ssmtest.beans.User;
import com.ssmtest.dao.UserDao;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
  public UserDaoImpl() {
	  super.setNs("com.ssmtest.beans.User");
  }

}
