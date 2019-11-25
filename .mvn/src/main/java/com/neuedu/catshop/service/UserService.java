package com.neuedu.catshop.service;


import java.util.List;

import com.neuedu.catshop.entity.User;

public interface UserService extends BaseService<User> {
	public List<User> findAll();
}
