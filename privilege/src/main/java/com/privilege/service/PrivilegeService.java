package com.privilege.service;

import java.util.List;
import java.util.Map;

import com.privilege.beans.ComboboxElement;
import com.privilege.beans.Privilege;
import com.privilege.tree.EasyuiTreeNode;

public interface PrivilegeService {
	public void delete(Privilege privilege);
	public void update(Privilege privilege);
	public Privilege selectOne(Privilege privilege);
	public List<Privilege> selectList(Map<String,Object> map);
	public void addPrivilege(Privilege privilege);
	public List<EasyuiTreeNode> selectTree(Privilege privilege, Integer roleID);
	public List<ComboboxElement> selectRoles(Privilege privilege);
	public void setRoles(Integer privilegeID, List<Integer> data);
}
