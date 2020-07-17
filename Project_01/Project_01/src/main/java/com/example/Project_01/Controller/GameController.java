package com.example.Project_01.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Project_01.Model.TestGame_1;
import com.example.Project_01.Repository.GameRepository;

@Controller
public class GameController {

	@Autowired
	GameRepository game_hm;
	@Autowired
	HttpSession session;

	@GetMapping("/testgame_1")
	public String Game_1(Model model) {
			
			List<TestGame_1> list = game_hm.findAll();
			model.addAttribute("list", list);
			System.out.println("list : " + list);
			
		return "testGame";
	}

	@GetMapping("/introgame_1")
	public String introGame_1() {
		return "Game_intro_hm1";
	}
	
	@GetMapping("/gameintro01")
	public String game_Intro_1() {

		return "testgame_intro";

	}

	@GetMapping("/testfile")
	public String game_Write_1() {

		return "testfile";

	}

	@PostMapping("/testfile") // ajax 안 들어가므로 Requestbody XXXX
	public String game_WritePost_1(@ModelAttribute TestGame_1 t1) {
		game_hm.save(t1);
		
		return "testfile";
	}

	
	//game board 조회하는 코드
	@GetMapping("/board_game01") 
//	@ResponseBody
	public String board_01(Model model) {
	
	List<TestGame_1> list = game_hm.findAll();
	model.addAttribute("list", list);
	System.out.println("list : " + list);
	
	return "/gameList_01";
	}
	
	
	@GetMapping("/testgame_2")
	public String Game_2() {
		return "game2";
	}
	
	@GetMapping("/testgame_3")
	public String Game_3() {
		return "game3";
	}

	


}
