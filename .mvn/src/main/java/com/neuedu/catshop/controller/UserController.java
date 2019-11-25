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
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.entity.User;
import com.neuedu.catshop.service.UserService;
import com.neuedu.catshop.util.FileuploadUtil;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("user/index")
	public String userIndex() {
		//首页只打开页面，不加载数据；页面的数据使用在easy ui中通过ajax技术进行异步加载的
		return "user/list"; 
		
	}
	
	@RequestMapping("user/list")
	@ResponseBody
	public Pages<User> userByNameList(@RequestParam(value="page",defaultValue = "1")Integer page,
			@RequestParam(value="rows",defaultValue = "10")Integer rows,HttpServletRequest request){
		Pages<User> pager=new Pages<>(page,rows);
		String userName=request.getParameter("userName1");
		System.out.println("用户名------------------------"+userName);
		if(userName !=null) {
			User user = new User();
			user.setUserName(userName);
			pager.setCondition(user);
		}
		
		//根据查询条件进行分页查询
		List<User> userList=userService.findListByPager(pager);
		
		Integer total=userService.findTotalByPager(pager);
		//把查询到的数据保存到pages对象中，在转换成json返回给easyUI
		pager.setRows(userList);
		pager.setTotal(total);
		
		pager.setRows(userList);
		return pager;
	}
	
//	//easyui请求时使用的是post方法，这里需要使用post方法
//	//easyui进行分页查询时，使用page传递查询的页码，使用rows传递查询的记录数
//	@RequestMapping("user/list")
//	@ResponseBody
//	public Pages<User> userList(@RequestParam(value="page",defaultValue = "1")Integer page,
//			@RequestParam(value="rows",defaultValue = "10")Integer rows){
//		Pages<User> pager=new Pages<>(page,rows);
//		
//		//根据查询条件进行分页查询
//		List<User> userList=userService.findListByPager(pager);
//		
//		Integer total=userService.findTotalByPager(pager);
//		//把查询到的数据保存到pages对象中，在转换成json返回给easyUI
//		pager.setRows(userList);
//		pager.setTotal(total);
//		
//		pager.setRows(userList);
//		return pager;
//	}
//	
	@RequestMapping("user/listall")
	@ResponseBody
	public List<User> listCategories() {
		return userService.findAll();
	}
	
	
	@RequestMapping("user/add")
	@ResponseBody
	public Result doAdd(MultipartFile imageFile,User user) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		user.setPic(serverFile);
		Result result = userService.add(user);
		return result;
	}

	@RequestMapping("user/edit")
	@ResponseBody
	public Result doEdit(MultipartFile imageFile,User user) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		user.setPic(serverFile);;
		Result result = userService.edit(user);
		return result;
	}

	
	  @RequestMapping("user/delete")
	  @ResponseBody 
	  public Result doDelete(Integer userId) {
	  
		  List<User> list = new ArrayList<User>();
		  list.add(new User(userId));
		  
		  Result result = userService.deleteByIds(list);
		  return result; 
	  }
}
