package com.privilege.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.privilege.beans.Privilege;
import com.privilege.beans.User;
import com.privilege.dao.PrivilegeDao;
import com.privilege.service.InitService;

@Service
public class InitServiceImpl implements InitService{
	
	@Resource
	private PrivilegeDao privilegeDao;

	@Override
	@Transactional(readOnly=true)
	public List<Privilege> getMenus(User user) {
		return privilegeDao.getMenus(user);
	}
	
}
