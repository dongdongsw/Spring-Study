package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodDAO fdao;

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return fdao.foodFindData(map);
	}

	@Override
	public int foodFindTotalData(String address) {
		// TODO Auto-generated method stub
		return fdao.foodFindTotalData(address);
	}
}
