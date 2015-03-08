package com.ssmtest.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssmtest.beans.Privilege;
import com.ssmtest.dao.PrivilegeDao;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Resource
	private PrivilegeDao privilegeDao;
	
	
	@Override
	public void addPrivilege(Privilege privilege) {
		this.privilegeDao.insert(privilege);
	}


	@Override
	public void delete(Privilege privilege) {
		this.privilegeDao.delete(privilege);
	}

	@Override
	public void update(Privilege privilege) {
		this.privilegeDao.updata(privilege);
	}

	@Override
	public Privilege selectOne(Privilege privilege) {
		return this.privilegeDao.selectOne(privilege);
	}

	@Override
	public List<Privilege> selectList(Map map) {
		return this.privilegeDao.selectList(map);
	}

}
