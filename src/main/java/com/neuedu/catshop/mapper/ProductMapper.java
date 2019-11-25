
package com.neuedu.catshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Product;

//使用注解标签声明数据访问层组件，spring会扫描该组件，并使用mybatis的代理类对其进行实例化
@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product>{
	
	/**
	 * 	带查询条件的记录总数
	 * @param pager
	 * @return
	 */
	@Select("select count(*) from product p left join kind k on p.kindId=k.kindId")
	@Override
	public Integer findTotalByPager(Pages<Product> pager);
	
	public List<Product> findAll();
}
