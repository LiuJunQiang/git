package com.privilege.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.privilege.beans.Role;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;
import com.privilege.dao.RoleDao;
import com.privilege.dao.UserDao;
import com.privilege.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	@Resource
	private RoleDao roleDao;
	
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void update(User user) {
		userDao.updata(user);
	}

	@Override
	public User selectOne(User user) {
		return userDao.selectOne(user);
	}

	@Override
	public List<User> selectList(Map<String,Object> map) {
		return userDao.selectList(map);
	}

	@Override
	public void add(User user) {
		userDao.insert(user);
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public void setRole(User_Role user_role) {
		userDao.setRole(user_role);
	}

	@Override
	public List<Role> selectRoles(User user) {
		return roleDao.selectRoles(user);
	}

}
