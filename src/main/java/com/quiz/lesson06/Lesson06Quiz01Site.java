package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.SiteBO;
import com.quiz.lesson06.domain.Site;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Site {
	
	@Autowired
	private SiteBO siteBO;
	
	// http://localhost:8080/lesson06/quiz01/add-site-view
	@GetMapping("/add-site-view")
	public String addSiteView() {
		return "lesson06/addSite";
	}
	
	@ResponseBody
	@PostMapping("/add-site")
	public Map<String, Object> addSite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		siteBO.addSite(name, url);
		
		// 성공여부는 JSON String 으로 내리겠다.
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; // JSON String
	}
	
	@GetMapping("/after-add-site-view")
	public String afterAddSiteView(Model model) {
		List<Site> siteList = siteBO.getSiteList();
		model.addAttribute("siteList", siteList);
		
		return "lesson06/afterAddSite";
	}
}
