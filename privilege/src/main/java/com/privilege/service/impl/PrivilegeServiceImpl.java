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
import com.privilege.dao.PrivilegeDao;
import com.privilege.dao.RoleDao;
import com.privilege.service.PrivilegeService;
import com.privilege.tree.EasyuiTreeNode;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Resource
	private PrivilegeDao privilegeDao;
	
	@Resource
	private RoleDao roleDao;
	
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


	@Override
	public List<EasyuiTreeNode> selectTree(Privilege privilege,Integer roleID) {
		
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
			
			if(count != null && count>0){
				node.setState("closed");
			}
			treeNodes.add(node);
		}
		return treeNodes;
	}


	@Override
	public List<ComboboxElement> selectRoles(Privilege privilege) {
		List<ComboboxElement> coms = new ArrayList<ComboboxElement>();
		
		List<Role> roles = roleDao.selectList(null);//查出所有role
		
		List<Role> selectedRoles  = privilegeDao.selectRoles(privilege);
		
			for (Role role : roles) {
				ComboboxElement com = new ComboboxElement();
				com.setId(role.getId());
				com.setText(role.getRoleName());
				for (Role sr : selectedRoles) {
					if(sr.getId().equals(role.getId())){
						com.setSelected(true);
						break;
					}
				}
				coms.add(com);
			}
		return coms;
	}


	@Override
	public void setRoles(Integer privilegeID, List<Integer> data) {
		Privilege privilege = new Privilege();
		privilege.setId(privilegeID);
			try {
				privilegeDao.deleteRoles(privilege);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		for (Integer roleID : data) {
			Role_Privilege role_privilege = new Role_Privilege();
			role_privilege.setRoleID(roleID);
			role_privilege.setPrivilegeID(privilegeID);
			
			privilegeDao.setRoles(role_privilege);
		}
	}

}
