package com.example.Project_01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class introController {

	@GetMapping("/intro")
	public String index() {
		return "/intro";

	}
	@GetMapping("/start")
	public String introGame_in() {
		return "homepageIntro";
	}
	
	@GetMapping("/game6start")
	public String introGame_6() {
		return "testGame4_int";
	}

}