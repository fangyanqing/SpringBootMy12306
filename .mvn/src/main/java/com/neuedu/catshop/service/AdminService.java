package com.neuedu.catshop.service;

import com.neuedu.catshop.entity.Admin;

public interface AdminService extends BaseService<Admin> {

	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin);
	public Admin findByName(String adminName);
}
