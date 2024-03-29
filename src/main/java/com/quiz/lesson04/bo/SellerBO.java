package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {

	@Autowired
	private SellerMapper sellerMapper;
	
	// input: Controller 에서 요청한 파라미터들
	// output: X
	public void addSeller(String nickname, String profileImage, double temperature) {
		sellerMapper.insertSeller(nickname, profileImage, temperature);
	}
	
	// input: X
	// output: Seller or null
	public Seller getLastestSeller() {
		return sellerMapper.selectLastestSeller();
	}
	
	// input : param("id")
	// output : seller or null
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
	
}
