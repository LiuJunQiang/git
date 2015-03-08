package com.privilege.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.privilege.beans.ComboboxElement;
import com.privilege.beans.Json;
import com.privilege.beans.Privilege;
import com.privilege.service.PrivilegeService;
import com.privilege.tree.EasyuiTreeNode;

@Controller
public class PrivilegeController {
	
	@Resource
	private PrivilegeService privilegeService;
	
	Json json = new Json();
	
	@RequestMapping("privilegeUI.action")
	public String privilegeUI(){
		return "/privilege/list.jsp";
	}
	
	@RequestMapping("privilege/delete.action")
	@ResponseBody
	public Json delete(Privilege privilege){
		privilegeService.delete(privilege);
		return json;
	}
	@RequestMapping("privilege/update.action")
	public Json update(Privilege privilege){  
		privilegeService.update(privilege);
		return json;
	}
	@RequestMapping("privilege/add.action")
	public Json add(Privilege privilege){
		privilegeService.addPrivilege(privilege);
		return json;
	}
	@RequestMapping("privilege/dataList.action")
	@ResponseBody
	public List<Privilege> datalist(){
		return privilegeService.selectList(null);
	}
	
	@RequestMapping("privilege/tree.action")
	@ResponseBody
	public List<EasyuiTreeNode> tree(Privilege privilege,@RequestParam("roleID")Integer roleID){
		List<EasyuiTreeNode> privileges =  privilegeService.selectTree(privilege,roleID);
		return privileges;
	}
	
	@RequestMapping("privilege/selectRoles.action")
	@ResponseBody
	public List<ComboboxElement> selectRoles(Privilege privilege){
		List<ComboboxElement> list = privilegeService.selectRoles(privilege);
		return list;
	}
	@RequestMapping("privilege/setRoles.action")
	@ResponseBody
	public Json setUsers(@RequestParam("data")List<Integer> data){
			Integer privilegeID = data.remove(0);
			privilegeService.setRoles(privilegeID,data);
		return json;
	}
	
}
