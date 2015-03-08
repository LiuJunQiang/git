package com.privilege.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.privilege.beans.Json;
import com.privilege.beans.Role;
import com.privilege.beans.User;
import com.privilege.beans.User_Role;
import com.privilege.service.RoleService;
import com.privilege.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	Json json = new Json();
	
	@RequestMapping("userUI.action")
	public String privilegeUI(Model model){
		List<Role> roles = roleService.selectList(null);
		model.addAttribute("roles", roles);
		return "/user/list.jsp";
	}
	
	@RequestMapping("user/delete.action")
	@ResponseBody
	public Json delete(User user){
		userService.delete(user);
		return json;
	}
	@RequestMapping("user/update.action")
	public Json update(User user){
		userService.update(user);
		return json;
	}
	@RequestMapping("user/add.action")
	public Json add(User user){
		userService.add(user);
		return json;
	}
	@RequestMapping("user/dataList.action")
	@ResponseBody
	public List<User> datalist(){
		return userService.selectList(null);
	}
	@RequestMapping("user/setRole.action")
	@ResponseBody
	public Json setRole(User_Role user_role){
		userService.setRole(user_role);
		return json;
	}
	
	@RequestMapping("user/selectRoles.action")
	@ResponseBody
	public List<Role> selectRoles(User user){
		List<Role> roles = userService.selectRoles(user);
		return roles;
	}
}


















