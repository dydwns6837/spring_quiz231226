package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.domain.Estate;

@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Quiz02RestController {

	@Autowired
	private EstateBO estateBO;
	
	// http://localhost:8080/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		Estate estate = new Estate();
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(100000);
		
		int rowCount = estateBO.addEstate(estate);
		return "입력 성공:" + rowCount;
	}
	
	// http://localhost:8080/lesson03/quiz02/2?realtorId=5
	@RequestMapping("/2")
	public String quiz02_2(
			@RequestParam("realtorId") int realtorId) {
		int rowCount = estateBO.insertEstateAsField(5, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "성공한 행의 개수:" + rowCount;
	}
}
