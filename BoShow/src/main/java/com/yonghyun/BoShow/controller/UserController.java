package com.yonghyun.BoShow.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yonghyun.BoShow.model.User;
import com.yonghyun.BoShow.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping({ "/signup" })
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:/";
	}

	@Autowired
	HttpSession session;

	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}

	@PostMapping("/signin")
	public String signinPost(@ModelAttribute User user) {
		User dbUser = userRepository.findByEmailAndPwd(user.getEmail(), user.getPwd());
		if (dbUser != null) {
			session.setAttribute("user_info", dbUser);
		}
		return "redirect:/";
	}

	@GetMapping("/signout")
	public String signout() {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping({ "/setting" })
	public String setting() {
		return "setting";
	}

	@PostMapping("/setting")
	public String settingPost(@ModelAttribute User user) {
		User sessionUser = (User) session.getAttribute("user_info");
		long id = sessionUser.getId();
		String email = sessionUser.getEmail();
		String pwd = sessionUser.getPwd();
		String name = sessionUser.getName();
		user.setId(id);
		user.setEmail(email);
		user.setPwd(pwd);
		user.setName(name);
		session.setAttribute("user_info", user);
		userRepository.save(user);
		return "setting";
	}

	@GetMapping({ "/userInfo" })
	public String userInfo() {
		return "userInfo";
	}

	@PostMapping("/userInfo")
	public String userInfoPost(@ModelAttribute User user) {
		User sessionUser = (User) session.getAttribute("user_info");
		long id = sessionUser.getId();
		String keyword1 = sessionUser.getKeyword1();
		String keyword2 = sessionUser.getKeyword2();
		String keyword3 = sessionUser.getKeyword3();
		String keyword4 = sessionUser.getKeyword4();
		String keyword5 = sessionUser.getKeyword5();
		int typeYoutubeEn = sessionUser.getTypeYoutubeEn();
		int typeKakaoBlogEn = sessionUser.getTypeKakaoBlogEn();
		int typeKakaoVideoEn = sessionUser.getTypeKakaoVideoEn();

		user.setId(id);
		user.setKeyword1(keyword1);
		user.setKeyword2(keyword2);
		user.setKeyword3(keyword3);
		user.setKeyword4(keyword4);
		user.setKeyword5(keyword5);
		user.setTypeYoutubeEn(typeYoutubeEn);
		user.setTypeKakaoBlogEn(typeKakaoBlogEn);
		user.setTypeKakaoVideoEn(typeKakaoVideoEn);
		session.setAttribute("user_info", user);
		userRepository.save(user);
		return "userInfo";
	}
}
