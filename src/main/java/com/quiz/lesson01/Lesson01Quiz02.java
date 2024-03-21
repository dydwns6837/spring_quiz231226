package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson01/quiz02")
public class Lesson01Quiz02 {
	
	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");
		
		// map1을 재활용하는 방법
		// map1 = new HashMap<>(); <== 이렇게 해줘도 지금 한 것과 같은 결과
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 0);
		map2.put("director", "로베르트 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		// list.add(map1); ==> 재활용시 바로바로 대입
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("rate", 12);
		map3.put("director", "크리스토퍼 놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("rate", 19);
		map4.put("director", "윤종빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		
		Map<String, Object> map5 = new HashMap<>();
		map5.put("rate", 15);
		map5.put("director", "프란시스 로렌스");
		map5.put("time", 137);
		map5.put("title", "헝거게임");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		
		return list;
	}
	
	// 2
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Cafe> quiz02_2() {
		// @ResponseBody + return String => HttpMessageConverter => HTML
		// @ResponseBody + return 객체(Map, 클래스, List) => HttpMessageConverter => jackson lib => JSON
		
		List<Cafe> list = new ArrayList<>();
		Cafe cafe1 = new Cafe();
		cafe1.setTitle("안녕하세요 가입인사 드립니다.");
		cafe1.setUser("marobiana");
		cafe1.setContent("안녕하세요. 가입했어요~");
		
		Cafe cafe2 = new Cafe();
		cafe2.setTitle("헐 대박");
		cafe2.setUser("bada");
		cafe2.setContent("오늘 금요일인줄");
		
		Cafe cafe3 = new Cafe();
		cafe3.setTitle("오늘 데이트 한 썰");
		cafe3.setUser("ryu");
		cafe3.setContent("...");
		
		list.add(cafe1);
		list.add(cafe2);
		list.add(cafe3);
		return list;
	}
	
	// 3
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Cafe> quiz02_3(){
		Cafe cafe1 = new Cafe();
		cafe1.setTitle("안녕하세요 가입인사 드립니다.");
		cafe1.setUser("marobiana");
		cafe1.setContent("안녕하세요. 가입했어요~");
		return new ResponseEntity<>(cafe1, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
