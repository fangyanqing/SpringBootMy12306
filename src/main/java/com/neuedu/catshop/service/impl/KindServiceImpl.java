package com.neuedu.catshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.catshop.entity.Kind;
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.mapper.KindMapper;
import com.neuedu.catshop.service.KindService;


@Service
@Transactional
public class KindServiceImpl implements KindService {

	@Autowired
	private KindMapper kindMapper;
	
	@Override
	public List<Kind> findListByPager(Pages<Kind> pager) {
		return kindMapper.findListByPager(pager);
	}

	@Override
	public Integer findTotalByPager(Pages<Kind> pager) {
		return kindMapper.findTotalByPager(pager);
	}
	
	@Override
	public List<Kind> findAll() {
		return kindMapper.findAll();
	}
	
	@Override
	public Result add(Kind object) {

		Result result = new Result(false, "新增商品失败！");
		boolean ret = kindMapper.add(object);
		if (ret) {
			result = new Result(true, "新增商品成功！");
		}
		return result;
	}

	@Override
	public Result edit(Kind object) {

		Result result = new Result(false, "修改商品失败！");
		boolean ret = kindMapper.edit(object);
		if (ret) {
			result = new Result(true, "修改商品成功！");
		}
		return result;
	}

	@Override
	public Result deleteByIds(List<Kind> ids) {

		Result result = new Result(false, "删除商品失败！");
		boolean ret = kindMapper.deleteByIds(ids);
		if (ret) {
			result = new Result(true, "删除商品成功！");
		}
		return result;
	}

}
