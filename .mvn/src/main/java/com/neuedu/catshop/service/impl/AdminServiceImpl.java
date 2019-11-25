package com.neuedu.catshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.catshop.entity.Admin;
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.mapper.AdminMapper;
import com.neuedu.catshop.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private AdminMapper adminMapper;

	
	@Override
	public List<Admin> findListByPager(Pages<Admin> pager) {
		return adminMapper.findListByPager(pager);
	}

	@Override
	public Integer findTotalByPager(Pages<Admin> pager) {
		return adminMapper.findTotalByPager(pager);
	}
	
	@Override
	public Result add(Admin object) {

		Result result = new Result(false, "新增失败！");
		boolean ret = adminMapper.add(object);
		if (ret) {
			result = new Result(true, "新增成功！");
		}
		return result;
	}

	@Override
	public Result edit(Admin object) {
		Result result = new Result(false, "修改失败！");
		boolean ret = adminMapper.edit(object);
		if (ret) {
			result = new Result(true, "修改成功！");
		}
		return result;
	}

	@Override
	public Result deleteByIds(List<Admin> ids) {
		Result result = new Result(false, "删除失败！");
		boolean ret = adminMapper.deleteByIds(ids);
		if (ret) {
			result = new Result(true, "删除成功！");
		}
		return result;
	}

	@Override
	public Admin login(Admin admin) {

		return adminMapper.login(admin);
	}

	@Override
	public Admin findByName(String adminName) {
		return adminMapper.findByName(adminName);
	}


	

}
