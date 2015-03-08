package com.privilege.service;

import java.util.List;
import java.util.Map;

import com.privilege.beans.Role;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;

public interface UserService {
	public void delete(User user);
	public void update(User user);
	public User selectOne(User user);
	public List<User> selectList(Map<String,Object> map);
	public void add(User user);
	public User login(User user);
	public List<Role> selectRoles(User user);
	void setRole(User_Role user_role);
}
