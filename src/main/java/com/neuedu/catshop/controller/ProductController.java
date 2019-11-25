package com.neuedu.catshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.catshop.entity.FileResult;
import com.neuedu.catshop.entity.Kind;
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Product;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.service.ProductService;
import com.neuedu.catshop.util.FileuploadUtil;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("product/index")
	public String productIndex() {
		// 首页只打开页面，不加载数据；页面的数据使用在easy ui中通过ajax技术进行异步加载的
		return "product/list";

	}

	// easyui请求时使用的是post方法，这里需要使用post方法
	// easyui进行分页查询时，使用page传递查询的页码，使用rows传递查询的记录数
	@RequestMapping("product/list")
	@ResponseBody
	public Pages<Product> productList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "10") Integer rows,HttpServletRequest request) {
		Pages<Product> pager = new Pages<>(page, rows);

		String kindName=request.getParameter("kind");
		if(kindName !=null) {
			Product product=new Product();
			Kind kind=new Kind();
			kind.setKindName(kindName);;
			product.setKind(kind);
			pager.setCondition(product);
		}
		
		
		// 根据查询条件进行分页查询
		List<Product> productList = productService.findListByPager(pager);

		Integer total = productService.findTotalByPager(pager);
		// 把查询到的数据保存到pages对象中，在转换成json返回给easyUI
		pager.setRows(productList);
		pager.setTotal(total);

		pager.setRows(productList);
		return pager;
	}
	
	@RequestMapping("product/listall")
	@ResponseBody
	public List<Product> listCategories() {
		return productService.findAll();
	}

	@RequestMapping("product/add")
	@ResponseBody
	public Result doAdd(MultipartFile imageFile, Product product) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		product.setTp(serverFile);
		Result result = productService.add(product);

		return result;
	}

	@RequestMapping("product/edit")
	@ResponseBody
	public Result doEdit(MultipartFile imageFile, Product product) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		product.setTp(serverFile);
		Result result = productService.edit(product);
		return result;
	}
	
	  
	  @RequestMapping("product/delete")
	  @ResponseBody 
	  public Result doDelete(Integer proid) {

		List<Product> list = new ArrayList<Product>();
		list.add(new Product(proid));

		Result result = productService.deleteByIds(list);
		return result;
	}
	 
}
