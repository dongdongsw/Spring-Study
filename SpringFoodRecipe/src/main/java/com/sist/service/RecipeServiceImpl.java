package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeDAO RDao;
	
	@Override
	public List<RecipeVO> RecipeListData(Map map) {
		
		return RDao.RecipeListData(map);
	}

	@Override
	public int RecipeListCount(Map map) {
		
		return RDao.RecipeListCount(map);
	}
	
}
