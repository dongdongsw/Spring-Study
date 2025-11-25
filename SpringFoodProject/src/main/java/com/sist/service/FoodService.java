package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.vo.FoodVO;


public interface FoodService {
	
	public List<FoodVO> foodFindData(Map map);
	
	public int foodFindCount(Map map);
	
}
