package com.neuedu.catshop.mapper;

import java.util.List;

import com.neuedu.catshop.entity.Pages;

public interface BaseMapper<T> {

	public List<T> findListByPager(Pages<T> pager);

	public Integer findTotalByPager(Pages<T> pager);

	public Boolean add(T object);

	public Boolean edit(T object);

	public Boolean deleteByIds(List<T> ids);
}

