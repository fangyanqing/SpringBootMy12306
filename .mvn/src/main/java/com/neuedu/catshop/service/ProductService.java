package com.neuedu.catshop.service;
import java.util.List;

import com.neuedu.catshop.entity.Product;

/**
 * 	根据大厂阿里巴巴的规范，加上接口注释
 * @author admin
 */
public interface ProductService extends BaseService<Product>{
	public List<Product> findAll();
}
