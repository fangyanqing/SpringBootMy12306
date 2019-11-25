package com.neuedu.catshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.catshop.entity.Admin;
import com.neuedu.catshop.entity.FileResult;
import com.neuedu.catshop.entity.Kind;
import com.neuedu.catshop.entity.Pages;
import com.neuedu.catshop.entity.Result;
import com.neuedu.catshop.service.AdminService;
import com.neuedu.catshop.util.FileuploadUtil;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("admin/index")
	public String adminIndex(String adminName,Model model) {
		//首页只打开页面，不加载数据；页面的数据使用在easy ui中通过ajax技术进行异步加载的
		if(adminName!=null) {
			model.addAttribute("adminList",adminName);
			return "admin/personal";
		}else {
			return "admin/list";
		}
		
	}
	
	@RequestMapping("admin/list")
	@ResponseBody
	public Pages<Admin> amdinList(@RequestParam(value="page",defaultValue = "1")Integer page,
			@RequestParam(value="rows",defaultValue = "10")Integer rows){
		Pages<Admin> pager=new Pages<>(page,rows);
		
		//根据查询条件进行分页查询
		List<Admin> adminList=adminService.findListByPager(pager);
		
		Integer total=adminService.findTotalByPager(pager);
		//把查询到的数据保存到pages对象中，在转换成json返回给easyUI
		pager.setRows(adminList);
		pager.setTotal(total);
		
		pager.setRows(adminList);
		return pager;
	}
	
	@RequestMapping("admin/personal")
	@ResponseBody
	public Pages<Admin> amdinByname(@RequestParam(value="page",defaultValue = "1")Integer page,
			@RequestParam(value="rows",defaultValue = "10")Integer rows,String adminName){
		Pages<Admin> pager=new Pages<>(page,rows);
		
		if(adminName!=null) {
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			pager.setCondition(admin);
		}
		//根据查询条件进行分页查询
		List<Admin> adminList=adminService.findListByPager(pager);
		System.out.println("pager-------------"+pager);
		Integer total=adminService.findTotalByPager(pager);
		//把查询到的数据保存到pages对象中，在转换成json返回给easyUI
		pager.setRows(adminList);
		pager.setTotal(total);
		
		pager.setRows(adminList);
		return pager;
	}
	
	
//	@RequestMapping("admin/personal")
//	@ResponseBody
//	public Admin findByName(String adminName){
//		Admin admin =new Admin();
//		if(adminName !=null) {
//			admin.setAdminName(adminName);
//			admin=adminService.findByName(adminName);
//		}	
//		System.out.println(admin);
//		return admin;
//	}
	
	
	
	@RequestMapping("admin/add")
	@ResponseBody
	public Result doAdd(MultipartFile imageFile,Admin admin) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		admin.setPic(serverFile);
		Result result = adminService.add(admin);
		return result;
	}

	@RequestMapping("admin/edit")
	@ResponseBody
	public Result doEdit(MultipartFile imageFile,Admin admin) {
		FileResult fileResult = FileuploadUtil.uplaodFile(imageFile);
		if (!fileResult.getSuccess()) {
			return new Result(false, fileResult.getMsg());
		}
		String serverFile = fileResult.getServerPath();
		admin.setPic(serverFile);
		Result result = adminService.edit(admin);
		return result;
	}

	
//	  @RequestMapping("admin/delete")
//	  @ResponseBody 
//	  public Result doDelete(Integer adminId) {
//	  
//		  List<Admin> list = new ArrayList<Admin>();
//		  list.add(new Admin(adminId));
//		  
//		  Result result = adminService.deleteByIds(list);
//		  return result; 
//	  }
	
}
