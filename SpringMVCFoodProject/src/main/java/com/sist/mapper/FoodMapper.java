package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {

	@Select("SELECT fno, name, address, price, poster, num "
			+ "FROM (SELECT fno, name, address, price, poster, rownum as num "
			+ "FROM (SELECT fno, name, address, price, poster "
			+ "FROM menupan_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalData();
	
	@Select("SELECT fno, name, poster, address, type, price, num "
			+ "FROM (SELECT fno, name, poster, address, type, price, rownum as num "
			+ "FROM (SELECT fno, name, poster, address, price, type "
			+ "FROM menupan_food "
			+ "WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food "
			+ "WHERE address LIKE '%'||#{address}||'%'")
	public int foodFindTotalData(String address);
}
