package com.neuedu.catshop.service.impl;

/**
 * 	根据大厂阿里巴巴的规范，加上接口注释
 * @author admin
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Product;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.mapper.ProductMapper;
import com.neuedu.catshop.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> findListByPager(Pages<Product> pager) {
		return productMapper.findListByPager(pager);
	}

	@Override
	public Integer findTotalByPager(Pages<Product> pager) {
		return productMapper.findTotalByPager(pager);
	}

	@Override
	public Result add(Product object) {

		Result result = new Result(false, "新增商品失败！");
		boolean ret = productMapper.add(object);
		if (ret) {
			result = new Result(true, "新增商品成功！");
		}
		return result;
	}

	@Override
	public Result edit(Product object) {

		Result result = new Result(false, "修改商品失败！");
		boolean ret = productMapper.edit(object);
		if (ret) {
			result = new Result(true, "修改商品成功！");
		}
		return result;
	}

	@Override
	public Result deleteByIds(List<Product> ids) {

		Result result = new Result(false, "删除商品失败！");
		boolean ret = productMapper.deleteByIds(ids);
		if (ret) {
			result = new Result(true, "删除商品成功！");
		}
		return result;
	}

	@Override
	public List<Product> findAll() {
		return productMapper.findAll();
	}

}
