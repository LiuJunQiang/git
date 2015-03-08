package com.privilege.service;

import java.util.List;

import com.privilege.beans.Privilege;
import com.privilege.beans.User;

public interface InitService {
	/**
	 * 获取初始化系统菜单
	 * @param user
	 * @return
	 */
	public List<Privilege> getMenus(User user);
}
