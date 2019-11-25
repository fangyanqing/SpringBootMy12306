package com.neuedu.catshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neuedu.catshop.entity.Admin;
import com.neuedu.catshop.service.AdminService;
import com.neuedu.catshop.util.Const;

@Controller
@SessionAttributes(value = { Const.SESSION_USER,Const.LOGIN_FAIL_COUNT, Const.ERROR_MSG })
public class LoginController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin/login")
	public String login() {

		return "login";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/admin/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login";
	}

	@PostMapping("/admin/login")
	public String doLogin(Admin admin, ModelMap model) {

		Integer counter = (Integer) model.get(Const.LOGIN_FAIL_COUNT);
		if (counter != null && ++counter > 5) {
			model.addAttribute(Const.ERROR_MSG, "登陆失败次数过多，请稍后再试！");
			return "redirect:/error";
		}

		Admin loginAdmin = adminService.login(admin);

		if (loginAdmin != null) {
//			model.addAttribute(Const.SESSION_USER, loginAdmin);
			model.addAttribute(Const.SESSION_USER, loginAdmin.getAdminName());
			model.remove(Const.LOGIN_FAIL_COUNT);
			model.remove(Const.ERROR_MSG);
			/* return "redirect:/"; */
			return "redirect:/";
		} else {
			model.addAttribute(Const.LOGIN_FAIL_COUNT, counter);
			return "redirect:/admin/login";
		}
	}
}
