package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.Estate;
import com.quiz.lesson03.mapper.EstateMapper;

@Service
public class EstateBO {
	
	@Autowired
	private EstateMapper estateMapper;
	
	public Estate getEstate(int id) {
		return estateMapper.selectEstate(id);
	}
	
	public Estate getEstateR(int rentPrice) {
		return estateMapper.selcetEstateR(rentPrice);
	}
	
	public List<Estate> getEstateList(int area, int price) {
		return estateMapper.selectEstateList(area, price);
	}
	
	public int addEstate(Estate estate) {
		return estateMapper.insertEstate(estate);
	}
	
	// insertEstateAsField(5, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120)
	public int insertEstateAsField(int realtorId, String address,
			int area, String type, int price, int rentPrice) {
		return estateMapper.insertEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateEstateById(int id, String type, int price) {
		return estateMapper.updateEstateById(id, type, price);
	}
	
	public void deleteEstateById(int id) {
		estateMapper.deleteEstateById(id);
	}
}
