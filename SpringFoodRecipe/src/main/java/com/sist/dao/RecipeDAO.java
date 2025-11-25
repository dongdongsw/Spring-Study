package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {

	/*
	 	@Select("SELECT no, title, chef FROM recipe WHERE ${column} AND '%'||#{ss}||'%'")
		public List<RecipeVO> RecipeListData(Map map);
		
		@Select("SELECT COUNT(*) FROM recipe WHERE ${column} AND '%'||#{ss}||'%'")
		public int RecipeListCount(Map map);
	 */
	@Autowired
	private RecipeMapper mapper;
	
	
	public List<RecipeVO> RecipeListData(Map map){
		return mapper.RecipeListData(map);
		
	}
	
	public int RecipeListCount(Map map){
		return mapper.RecipeListCount(map);
	}
}
