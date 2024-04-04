package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

// 2강 @RestController
@Controller
public class Lesson02Quiz01RestController {
	
	@Autowired
	private StoreBO storeBO;
	
	// 2강 http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		return storeBO.getStoreList();
	}
	
	// 5강 http://localhost:8080/store-list-view
	@GetMapping("/store-list-view")
	public String storeListView() {
		return "lesson02/storeList";
	}
	// http://localhost:8080/store-reviews
	@GetMapping("/store-reviews")
	public String StoreReviews() {
		return "lesson02/reviews";
	}
}
