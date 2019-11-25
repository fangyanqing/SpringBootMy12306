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
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.service.KindService;
import com.neuedu.catshop.util.FileuploadUtil;

@Controller
public class KindController {

	@Autowired
	private KindService kindService;
	
	@RequestMapping("kind/index")
	public String kindIndex() {
		//首页只打开页面，不加载数据；页面的数据使用在easy ui中通过ajax技术进行异步加载的
		return "kind/list"; 
		
	}
	
	//easyui请求时使用的是post方法，这里需要使用post方法
	//easyui进行分页查询时，使用page传递查询的页码，使用rows传递查询的记录数
	@RequestMapping("kind/list")
	@ResponseBody
	public Pages<Kind> kindList(@RequestParam(value="page",defaultValue = "1")Integer page,
			@RequestParam(value="rows",defaultValue = "10")Integer rows,HttpServletRequest request){
		Pages<Kind> pager=new Pages<>(page,rows);
		
		String kindName=request.getParameter("kind");
		if(kindName !=null) {
			Kind kind=new Kind(kindName);
			pager.setCondition(kind);
		}
		
		
		//根据查询条件进行分页查询
		List<Kind> kindList=kindService.findListByPager(pager);
		
		Integer total=kindService.findTotalByPager(pager);
		//把查询到的数据保存到pages对象中，在转换成json返回给easyUI
		pager.setRows(kindList);
		pager.setTotal(total);
		
		
		pager.setRows(kindList);
		return pager;
	}
	
	@RequestMapping("kind/listall")
	@ResponseBody
	public List<Kind> listCategories() {
		return kindService.findAll();
	}
	
	@RequestMapping("kind/add")
	@ResponseBody
	public Result doAdd(MultipartFile imageFile,Kind kind) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		kind.setKindImage(serverFile);
		Result result = kindService.add(kind);
		return result;
	}

	@RequestMapping("kind/edit")
	@ResponseBody
	public Result doEdit(MultipartFile imageFile,Kind kind) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		kind.setKindImage(serverFile);
		Result result = kindService.edit(kind);
		return result;
	}

	
	  @RequestMapping("kind/delete")
	  @ResponseBody 
	  public Result doDelete(Integer kindId) {
	  
		  List<Kind> list = new ArrayList<Kind>();
		  list.add(new Kind(kindId));
		  
		  Result result = kindService.deleteByIds(list);
		  return result; 
	  }
	 
	
}
