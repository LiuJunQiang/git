package com.ssmtest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssmtest.beans.Privilege;
import com.ssmtest.service.PrivilegeService;

@Controller
public class PrivilegeController {
	
	@Resource
	private PrivilegeService privilegeService;
	
	@RequestMapping("privilegeUI.action")
	public String privilegeUI(){
		return "/privilege/list.jsp";
	}
	
	@RequestMapping("addprivilege.action")
	public String add(Privilege privilege){
		privilegeService.addPrivilege(privilege);
		return "success";
	}
	
	@RequestMapping("privilegeDataList.action")
	@ResponseBody
	public List<Privilege> datalist(){
		return privilegeService.selectList(null);
	}
}
