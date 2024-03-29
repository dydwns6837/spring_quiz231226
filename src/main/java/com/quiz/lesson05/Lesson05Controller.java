package com.quiz.lesson05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Lesson05Controller {
	
	// http://localhost:8080/lesson05/quiz01
	@GetMapping("/lesson05/quiz01")
	public String quiz() {
		return "lesson05/quiz01";
	}
	
	// http://localhost:8080/lesson05/quiz02
	@GetMapping("/lesson05/quiz02")
	public String quiz02(Model model) {
		List<String> musicRanking = new ArrayList<>();
		musicRanking.add("강남스타일");
		musicRanking.add("벚꽃엔딩");
		musicRanking.add("좋은날");
		musicRanking.add("거짓말");
		musicRanking.add("보고싶다");
		model.addAttribute("musicRanking", musicRanking);
		
		return "lesson05/quiz02";
	}
}
