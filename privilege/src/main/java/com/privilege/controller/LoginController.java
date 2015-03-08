package com.privilege.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.privilege.beans.Json;
import com.privilege.beans.Privilege;
import com.privilege.beans.User;
import com.privilege.service.InitService;
import com.privilege.service.UserService;

@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private InitService initService;
	
	Json json = new Json();
	
	@RequestMapping("login.action")
	public String login(Model model,HttpSession session,User user){
		User u = userService.login(user);
		if(u != null){
			session.setAttribute("userID", u.getId());
			session.setAttribute("username", u.getUsername());
		}
		
		//添加主题到页面
		model.addAttribute("themes", this.getThemes(session));
		
		return "/base/home.jsp";
	}
	
	@RequestMapping("init/init.action")
	@ResponseBody
	private List<Privilege> init(Model model,User u){
		List menus =initService.getMenus(u);
		return menus;
	}
	//获取主题
	private List<String> getThemes(HttpSession session){
		List<String> themes = new ArrayList<String>();
		
		String path = session.getServletContext().getRealPath("/");
		File files = new File(path+"js/jquery-easyui-1.4.2/themes/");
		
		
		if(files.isDirectory()){
			File[] fs = files.listFiles();
			for (File file : fs) {
				if (file.isDirectory()) {
					if(file.getName().equals("icons")){
						continue;
					}
					themes.add(file.getName());
				}
			}
		}
		
		return themes;
	}
}
