package com.neuedu.catshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.entity.User;
import com.neuedu.catshop.mapper.UserMapper;
import com.neuedu.catshop.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findListByPager(Pages<User> pager) {
		return userMapper.findListByPager(pager);
	}

	@Override
	public Integer findTotalByPager(Pages<User> pager) {
		return userMapper.findTotalByPager(pager);
	}

	@Override
	public Result add(User object) {

		Result result = new Result(false, "新增失败！");
		boolean ret = userMapper.add(object);
		if (ret) {
			result = new Result(true, "新增成功！");
		}
		return result;
	}

	@Override
	public Result edit(User object) {
		Result result = new Result(false, "修改失败！");
		boolean ret = userMapper.edit(object);
		if (ret) {
			result = new Result(true, "修改成功！");
		}
		return result;
	}

	@Override
	public Result deleteByIds(List<User> ids) {
		Result result = new Result(false, "删除失败！");
		boolean ret = userMapper.deleteByIds(ids);
		if (ret) {
			result = new Result(true, "删除成功！");
		}
		return result;
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

}
