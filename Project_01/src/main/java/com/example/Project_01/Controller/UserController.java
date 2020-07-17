package com.example.Project_01.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Project_01.Model.User;
import com.example.Project_01.Repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	

	@GetMapping("/signup")
	public String signup() {
		return "/signin";
	}

	@PostMapping("/signup")
	@ResponseBody
	public String signupPost(@ModelAttribute User user) {
		// 중복 아이디 가입 불가를 위해서 가입여부 확인
		User findUser = userRepository.findByEmail(user.getEmail());
		System.out.println("@@@@" + findUser);
		if (findUser == null) {
			userRepository.save(user);
		} else {
			return "0";
		}
		return "1";
	}
	
	
	@GetMapping("/signout")
	public String signout() {
		session.removeAttribute("user_info");		// 지정된 세션값만 삭제
		session.invalidate();						// 세션의 모든 정보 삭제
		return "redirect:/";
	}

	@GetMapping("/signin")		// login
	public String signin() {
		return "signin";
	}

	@PostMapping("/signin")
    @ResponseBody
	public Map<String, Object> signinPost(@ModelAttribute User user) {
		Map<String, Object> map = new HashMap<>();
		User dbUser = userRepository.findByEmailAndPwd(user.getEmail(), user.getPwd());
		if (dbUser != null) {
			session.setAttribute("user_info", dbUser);
			map.put("code", 200);
			map.put("msg", "success");
			map.put("name", dbUser.getName());
		} else {
			map.put("code", 201);
			map.put("msg", "fail");
		}
		return map;
	}
	
}