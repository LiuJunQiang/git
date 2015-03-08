package com.ssmtest.service;

import java.util.List;
import java.util.Map;

import com.ssmtest.beans.Privilege;

public interface PrivilegeService {
	public void delete(Privilege privilege);
	public void update(Privilege privilege);
	public Privilege selectOne(Privilege privilege);
	public List<Privilege> selectList(Map map);
	public void addPrivilege(Privilege privilege);
}
