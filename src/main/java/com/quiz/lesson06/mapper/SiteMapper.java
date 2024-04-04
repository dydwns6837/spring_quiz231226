package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Site;

@Mapper
public interface SiteMapper {
	
	public void insertSite(
			@Param("name") String name,
			@Param("url") String url);
	
	public List<Site> selectSiteList();
}
