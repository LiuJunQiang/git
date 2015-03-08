package com.privilege.dao;

import java.util.List;
import java.util.Map;

import com.privilege.beans.Role;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;

public interface UserDao extends BaseDao<User> {

	User login(User user);

	void setRole(User_Role user_role);
}
