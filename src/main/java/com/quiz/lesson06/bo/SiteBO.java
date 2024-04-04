package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Site;
import com.quiz.lesson06.mapper.SiteMapper;

@Service
public class SiteBO {
	
	@Autowired
	private SiteMapper siteMapper;
	
	// insert : 제목과 주소
	// output : x
	public void addSite(String name, String url) {
		siteMapper.insertSite(name, url);
	}
	
	public List<Site> getSiteList() {
		return siteMapper.selectSiteList();
	}
}
