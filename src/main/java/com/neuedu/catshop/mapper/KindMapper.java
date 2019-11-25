package com.neuedu.catshop.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.neuedu.catshop.entity.Kind;
import com.neuedu.catshop.entity.Pages;

@Mapper
@Repository
public interface KindMapper extends BaseMapper<Kind>{
	
	/**
	 * 	带查询条件的记录总数
	 * @param pager
	 * @return
	 */
	@Select("select count(*) from kind ")
	@Override
	public Integer findTotalByPager(Pages<Kind> pager);
	/**
	 * 在Mapper接口中可以自定义本接口需要的接口
	 * 
	 * @return
	 */
	public List<Kind> findAll();
}
