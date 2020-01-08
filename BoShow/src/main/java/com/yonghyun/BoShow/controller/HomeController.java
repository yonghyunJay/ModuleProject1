package com.yonghyun.BoShow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yonghyun.BoShow.model.Data;
import com.yonghyun.BoShow.model.User;

@Controller
public class HomeController {
	@GetMapping({ "/", "/home" })
	public String index() {
		return "login";
	}
}