package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03 {
	
	// http://localhost:8080/lesson01/quiz03
	@RequestMapping("/lesson01/quiz03")
	public String quiz03() {
		// @ResponseBody가 아닌 상태로 return String을 하면
		// ViewResolver에 의해 리턴된 string jsp 경로를 찾고
		// jsp => html 화면이 구성된다.
		
		return "lesson01/quiz03";
	}
}
