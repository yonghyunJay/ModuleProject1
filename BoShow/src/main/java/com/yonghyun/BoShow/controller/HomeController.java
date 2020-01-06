package com.yonghyun.BoShow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yonghyun.BoShow.model.Data;
import com.yonghyun.BoShow.model.User;

@Controller
public class HomeController {
	@GetMapping({ "/", "/home" })
	public String index() {
		
//		Data d = new Data();
//		User user = new User();
//		d.setUser(user);
		
		
		
		return "index";
	}
}