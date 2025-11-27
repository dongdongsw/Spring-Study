package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {

	@Autowired
	private FoodMapper mapper;
	
	/*
	 @Select("SELECT fno, name, address, price, poster, num "
			+ "FROM (SELECT fno, name, address, price, poster, rownum as num "
			+ "FROM (SELECT fno, name, address, price, poster "
			+ "FROM menupanFood)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM menupanFood")
	public int foodTotalData();
	 */
	public List<FoodVO> foodListData(int start, int end){
		return mapper.foodListData(start, end);
	}
	public int foodTotalData() {
		return mapper.foodTotalData();
	}
	
	/*
	 @Select("SELECT fno, name, poster, address, type, num "
			+ "FROM (SELECT fno, name, poster, address, type, rownum as num "
			+ "FROM (SELECT fno, name, poster, address, type "
			+ "FROM menupan_food ORDER BY ASC "
			+ "WHERE address LIKE '%'||#{address}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM menupan_food "
			+ "WHERE address LIKE '%'||#{address}||'%'))")
	public int foodFindTotalData(String address);
	 */
	public List<FoodVO> foodFindData(Map map){
		return mapper.foodFindData(map);
	}
	
	public int foodFindTotalData(String address) {
		return mapper.foodFindTotalData(address);
	}


}
