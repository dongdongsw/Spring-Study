package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno, name, address, type, phone FROM menupan_food "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT COUNT(*) FROM menupan_food "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int foodFindCount(Map map);
}
