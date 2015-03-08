package com.privilege.service;

import java.util.List;
import java.util.Map;

import com.privilege.beans.ComboboxElement;
import com.privilege.beans.Privilege;
import com.privilege.beans.Role;
import com.privilege.tree.EasyuiTreeNode;

public interface RoleService {
	public void delete(Role role);
	public void update(Role role);
	public Role selectOne(Role role);
	public List<Role> selectList(Map<String,Object> map);
	public void add(Role role);
	public void setPrivilege(List<Integer> list);
	public List<EasyuiTreeNode> selectTree(Privilege privilege, Integer roleID);
	public List<ComboboxElement> selectUser(Role role);
	public void setUsers(Integer roleID, List<Integer> usersID);
}
