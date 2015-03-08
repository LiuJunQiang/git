package com.privilege.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.privilege.beans.ComboboxElement;
import com.privilege.beans.Privilege;
import com.privilege.beans.Role;
import com.privilege.beans.Role_Privilege;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;
import com.privilege.dao.PrivilegeDao;
import com.privilege.dao.RoleDao;
import com.privilege.dao.UserDao;
import com.privilege.service.RoleService;
import com.privilege.tree.EasyuiTreeNode;

@Service
public class RoleServiceimpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;
	
	@Resource
	private PrivilegeDao privilegeDao;
	
	@Resource
	private UserDao userDao;
	
	@Override
	public void delete(Role role) {
		roleDao.delete(role);
	}

	@Override
	public void update(Role role) {
		roleDao.updata(role);
	}

	@Override
	public Role selectOne(Role role) {
		return roleDao.selectOne(role);
	}

	@Override
	public List<Role> selectList(Map map) {
		return roleDao.selectList(map);
	}

	@Override
	public void add(Role role) {
		roleDao.insert(role);
	}

	@Override
	public void setPrivilege(List<Integer> list) {
		Role role = new Role();
		role.setId(list.get(0));
		roleDao.deletePrivileges(role);
		
		for(int i=1;i<list.size();i++){
			Role_Privilege rp = new Role_Privilege();
			rp.setRoleID(list.get(0));
			rp.setPrivilegeID(list.get(i));
			roleDao.saveRelativity(rp);
		}
		
	}

	@Override
	public List<EasyuiTreeNode> selectTree(Privilege privilege,Integer roleID) {
		
		Role role = new Role();
		role.setId(roleID);
		
		List<Privilege> selectPrivileges =  privilegeDao.selectPrivileges(role);
		
		Integer id = privilege.getId();
		if(id == null){ id = 0;}
		privilege.setId(id);
		
		List<Privilege> list= this.privilegeDao.selectTree(privilege);
		
		List<EasyuiTreeNode> treeNodes = new ArrayList<EasyuiTreeNode>();
		
		for (Privilege p : list) {
			EasyuiTreeNode node = new EasyuiTreeNode();
			node.setId(p.getId());
			node.setText(p.getPrivilegeName());
			Integer count = this.privilegeDao.selectCount(p.getId());
			if (count != null && count > 0) {
				node.setState("closed");
			}
			for (Privilege s : selectPrivileges) {
					if(privilege.getId().equals(s.getId())){
						node.setChecked(true);
					}else if(node.getId().equals(s.getId())){
						node.setChecked(true);
						break;
					}
			} 
			treeNodes.add(node);
		}
		return treeNodes;
	}

	@Override
	public List<ComboboxElement> selectUser(Role role) {
		List<ComboboxElement> coms = new ArrayList<ComboboxElement>();
		
		List<User> users = userDao.selectList(null);//查出所有user
		
		List<User> selectedUsers  = roleDao.selectUsers(role);
		
			for (User user : users) {
				ComboboxElement com = new ComboboxElement();
				com.setId(user.getId());
				com.setText(user.getUsername());
				for (User su : selectedUsers) {
					if(su.getId().equals(user.getId())){
						com.setSelected(true);
						break;
					}
				}
				coms.add(com);
			}
		return coms;
	}

	@Override
	public void setUsers(Integer roleID, List<Integer> usersID) {
		Role role =new Role();
		role.setId(roleID);
		
			try {
				roleDao.deleteUsers(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		for (Integer userID : usersID) {
			User_Role user_role = new User_Role();
			user_role.setRoleID(roleID);
			user_role.setUserID(userID);
			roleDao.setUsers(user_role);
		}
	}
}
