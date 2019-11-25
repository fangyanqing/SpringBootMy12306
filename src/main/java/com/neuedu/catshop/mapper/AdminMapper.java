package com.neuedu.catshop.mapper;

import com.neuedu.catshop.entity.Admin;

public interface AdminMapper extends BaseMapper<Admin> {

	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin);
	
	public Admin findByName(String adminName);
}
