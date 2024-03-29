package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.Estate;

@Mapper
public interface EstateMapper {
	
	public Estate selectEstate(int id);
	
	public Estate selcetEstateR(int rentPrice);
	
	// xml로 파라미터를 보낼 때 한 개 밖에 보낼 수 없다.
	// 파라미터들을 하나의 Map에 담아 보낸다.
	// @Param 어노테이션을 붙이면 하나의 Map이 된다.
	public List<Estate> selectEstateList(
			@Param("area") int area, 
			@Param("price") int price);
	
	public int insertEstate(Estate estate);
	
	public int insertEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address,
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") int rentPrice);
	
	public int updateEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	public void deleteEstateById(int id);
}
