package com.neuedu.catshop.service;

import java.util.List;

import com.neuedu.catshop.entity.Kind;

public interface KindService extends BaseService<Kind>{
	/**
	 * 在Mapper接口中可以自定义本接口需要的接口
	 * 
	 * @return
	 */
	public List<Kind> findAll();
}
