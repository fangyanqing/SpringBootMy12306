package com.neuedu.catshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.catshop.entity.OrderInfo;
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.mapper.OrderInfoMapper;
import com.neuedu.catshop.service.OrderInfoService;

@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService{

	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Override
	public List<OrderInfo> findListByPager(Pages<OrderInfo> pager) {
		return orderInfoMapper.findListByPager(pager);
	}

	@Override
	public Integer findTotalByPager(Pages<OrderInfo> pager) {
		return orderInfoMapper.findTotalByPager(pager);
	}

	@Override
	public Result add(OrderInfo object) {

		Result result = new Result(false, "新增失败！");
		boolean ret = orderInfoMapper.add(object);
		if (ret) {
			result = new Result(true, "新增成功！");
		}
		return result;
	}

	@Override
	public Result edit(OrderInfo object) {
		Result result = new Result(false, "修改失败！");
		boolean ret = orderInfoMapper.edit(object);
		if (ret) {
			result = new Result(true, "修改成功！");
		}
		return result;
	}

	@Override
	public Result deleteByIds(List<OrderInfo> ids) {
		Result result = new Result(false, "删除失败！");
		boolean ret = orderInfoMapper.deleteByIds(ids);
		if (ret) {
			result = new Result(true, "删除成功！");
		}
		return result;
	}


}
