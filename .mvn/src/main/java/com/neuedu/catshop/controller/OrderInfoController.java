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

import com.neuedu.catshop.entity.Kind;
import com.neuedu.catshop.entity.OrderInfo;
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Product;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.service.OrderInfoService;

@Controller
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;

	@RequestMapping("orderInfo/index")
	public String orderInfoIndex() {
		// 首页只打开页面，不加载数据；页面的数据使用在easy ui中通过ajax技术进行异步加载的
		return "orderInfo/list";

	}

	// easyui请求时使用的是post方法，这里需要使用post方法
	// easyui进行分页查询时，使用page传递查询的页码，使用rows传递查询的记录数
	@RequestMapping("orderInfo/list")
	@ResponseBody
	public Pages<OrderInfo> orderInfoList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "10") Integer rows,HttpServletRequest request) {
		Pages<OrderInfo> pager = new Pages<>(page, rows);

		String orderState=request.getParameter("orderState");
		if(orderState !=null) {
			OrderInfo orderInfo=new OrderInfo();
			orderInfo.setOrderState(orderState);
			pager.setCondition(orderInfo);
		}
		
		
		// 根据查询条件进行分页查询
		List<OrderInfo> orderInfoList = orderInfoService.findListByPager(pager);

		Integer total = orderInfoService.findTotalByPager(pager);
		// 把查询到的数据保存到pages对象中，在转换成json返回给easyUI
		pager.setRows(orderInfoList);
		pager.setTotal(total);

		pager.setRows(orderInfoList);
		return pager;
	}

	@RequestMapping("orderInfo/add")
	@ResponseBody
	public Result doAdd(MultipartFile imageFile, OrderInfo orderInfo) {
//		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
//		if (!fileResult.getSuccess()) {
//			return new Result(false, fileResult.getMsg());
//		}
//		String serverFile = fileResult.getServerPath();
//		product.setTp(serverFile);
		Result result = orderInfoService.add(orderInfo);

		return result;
	}

	@RequestMapping("orderInfo/edit")
	@ResponseBody
	public Result doEdit(MultipartFile imageFile, OrderInfo orderInfo) {
//		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
//		if (!fileResult.getSuccess()) {
//			return new Result(false, fileResult.getMsg());
//		}
//		String serverFile = fileResult.getServerPath();
//		product.setTp(serverFile);
		Result result = orderInfoService.edit(orderInfo);
		return result;
	}
	
	  
	  @RequestMapping("orderInfo/delete")
	  @ResponseBody 
	  public Result doDelete(Integer orderId) {

		List<OrderInfo> list = new ArrayList<OrderInfo>();
		list.add(new OrderInfo(orderId));

		Result result = orderInfoService.deleteByIds(list);
		return result;
	}
	
}
