package com.yonghyun.BoShow.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonghyun.BoShow.model.Data;
import com.yonghyun.BoShow.model.User;
import com.yonghyun.BoShow.repository.DataRepository;
import com.yonghyun.BoShow.repository.UserRepository;

@Controller
public class UserController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
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
			return "redirect:/index";
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
		
		user.setId(sessionUser.getId());
		user.setKeyword1(sessionUser.getKeyword1());
		user.setKeyword2(sessionUser.getKeyword2());
		user.setKeyword3(sessionUser.getKeyword3());
		user.setKeyword4(sessionUser.getKeyword4());
		user.setKeyword5(sessionUser.getKeyword5());
		user.setTypeYoutubeEn(sessionUser.getTypeYoutubeEn());
		user.setTypeKakaoBlogEn(sessionUser.getTypeKakaoBlogEn());
		user.setTypeKakaoVideoEn(sessionUser.getTypeKakaoVideoEn());
		user.setTypeNaverNewsEn(sessionUser.getTypeNaverNewsEn());
		user.setTypeNaverBlogEn(sessionUser.getTypeNaverBlogEn());
		user.setTypeNaverCafeEn(sessionUser.getTypeNaverCafeEn());
				
		session.setAttribute("user_info", user);
		userRepository.save(user);
		return "userInfo";
	}
	
	@Autowired
	DataRepository dataRepository;
	
	@PostMapping("/setCollect")
	public String setCollect(@ModelAttribute Data data) {
		User sessionUser = (User) session.getAttribute("user_info");
		
		data.setTitle(data.getTitle());
		data.setThumb(data.getThumb());
		data.setDesc(data.getDesc());
		data.setLink(data.getLink());
		data.setSrc(data.getSrc());
		data.setUser(sessionUser);
		
		dataRepository.save(data);
			
		return "redirect:/";
	}
	
	@GetMapping("/getCollect")
	@ResponseBody
	public List<Data> getCollect() {
		User sessionUser = (User) session.getAttribute("user_info");
		List<Data> datas = dataRepository.findAllByUser(sessionUser);
				
		return datas;
	}
}
