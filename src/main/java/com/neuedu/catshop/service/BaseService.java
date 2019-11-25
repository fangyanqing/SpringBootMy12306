package com.neuedu.catshop.service;

import java.util.List;

import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Result;

public interface BaseService<T> {
	
	public List<T> findListByPager(Pages<T> pager);

	public Integer findTotalByPager(Pages<T> pager);

	public Result add(T object);

	public Result edit(T object);

	public Result deleteByIds(List<T> ids);
}


