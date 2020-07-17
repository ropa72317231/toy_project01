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

	@GetMapping("/testgame_1") //초성게임 >  직업 
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
	
	
	@GetMapping("/testgame_2") //홀짝 게임 
	public String Game_2() {
		return "game2";
	}
	
	@GetMapping("/testgame_3") //복불복게임
	public String Game_3() {
		return "game3";
	}

	@GetMapping("/testgame_4") //초성 > 나라 이름 
	public String Game_4() {
		return "testGame2";
	}
	
	@GetMapping("/testgame_5") //초성  > 게임 이름
	public String Game_5() {
		return "testGame3";
	}
	
	@GetMapping("/testgame_6") //잰말게임
	public String Game_6() {
		return "testGame4";
	}
	
	
	@GetMapping("/testgame_7info") //Random 숫자맞추기 게임 선택창
	public String Game_7Info() {
		return "testGame5Int";
	}
	
	@GetMapping("/testgame_7") //Random 숫자맞추기 게임
	public String Game_7() {
		return "testGame5";
	}
	
	
	@GetMapping("/testgame_8") // 사칙연산 게임
	public String Game_8() {
		return "game4";
	}
	
	@GetMapping("/testgame_9") // 꼬리물기
	public String Game_9() {
		return "game1-1";
	}
	
	@GetMapping("/testgame_10") // 
	public String Game_10() {
		return "game2-1";
	}
	
	@GetMapping("/testgame_11") // 
	public String Game_11() {
		return "game3-1";
	}
	
	@GetMapping("/testgame_12") // 슈팅게임
	public String Game_12() {
		return "슈팅게임";
	}
	
	@GetMapping("/testgame_13") // 핑퐁
	public String Game_13() {
		return "핑퐁";
	}
	


}
