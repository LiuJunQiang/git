package com.privilege.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.privilege.beans.ComboboxElement;
import com.privilege.beans.Json;
import com.privilege.beans.Privilege;
import com.privilege.beans.Role;
import com.privilege.service.RoleService;
import com.privilege.tree.EasyuiTreeNode;

@Controller
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	Json json = new Json();
	
	@RequestMapping("roleUI.action")
	public String privilegeUI(){
		return "/role/list.jsp";
	}
	
	@RequestMapping("role/delete.action")
	@ResponseBody
	public Json delete(Role role){
		roleService.delete(role);
		return json;
	}
	@RequestMapping("role/update.action")
	public Json update(Role role){
		roleService.update(role);
		return json;
	}
	@RequestMapping("role/add.action")
	public Json add(Role role){
		System.out.println("rolename:"+role.getRoleName());
		
		roleService.add(role);
		return json;
	}
	@RequestMapping("role/dataList.action")
	@ResponseBody
	public List<Role> datalist(){
		return roleService.selectList(null);
	}
	@RequestMapping("role/setPrivilege.action")
	@ResponseBody
	public Json setPrivilege(@RequestParam("data")List<Integer> data){
		roleService.setPrivilege(data);
		return json;
	}
	
	@RequestMapping("role/selectPrivileges.action")
	@ResponseBody
	public List<EasyuiTreeNode> tree(Privilege privilege,@RequestParam("roleID")Integer roleID){
		List<EasyuiTreeNode> privileges =  roleService.selectTree(privilege,roleID);
		return privileges;
	}
	
	@RequestMapping("role/selectUsers.action")
	@ResponseBody
	public List<ComboboxElement> selectUsers(Role role){
		List<ComboboxElement> list = roleService.selectUser(role);
		return list;
	}
	@RequestMapping("role/setUsers.action")
	@ResponseBody
	public Json setUsers(@RequestParam("data")List<Integer> data){
			Integer roleID = data.remove(0);
			roleService.setUsers(roleID,data);
		return json;
	}
	
}
