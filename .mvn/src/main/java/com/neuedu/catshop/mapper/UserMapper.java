package com.neuedu.catshop.mapper;


import java.util.List;
import com.neuedu.catshop.entity.User;

public interface UserMapper extends BaseMapper<User>{
	public List<User> findAll();
}
