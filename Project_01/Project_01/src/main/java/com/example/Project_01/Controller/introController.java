package com.example.Project_01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class introController {

	@GetMapping("/intro")
	public String index() {
		return "/intro";

	}

}