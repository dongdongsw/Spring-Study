package com.sist.service;

import java.util.*;

import com.sist.vo.*;

/*
 *	클라이언트 ===== Service ===== DAO ===== 오라클
 *                               |
 *                              수정 
 */

public interface FoodService {
	public List<FoodVO> FoodListData(int start, int end);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	public FoodVO foodCookieData(int fno);
	
	// 검색
	public List<FoodVO> FoodFindData(Map map);
	public int foodFindTotalPage(String address);
	
	// 타입
	public List<FoodVO> FoodTypeData(Map map);
	public int foodTypeTotalPage(String type);
}
