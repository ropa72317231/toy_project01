package com.example.Project_01.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({ "/", "/home" })
	public String index() {
		return "index";
	}
}