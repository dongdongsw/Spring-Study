package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Service
public class RecipeServiceInpl implements RecipeService{
	
	@Autowired
	private RecipeDAO rdao;

	@Override
	public List<RecipeVO> recipeListData(int start, int end) {

		return rdao.recipeListData(start, end);
	}

	@Override
	public int recipeTotalPage() {
		
		return rdao.recipeTotalPage();
	}

	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		// TODO Auto-generated method stub
		return rdao.recipeFindData(map);
	}

	@Override
	public int recipeFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return rdao.recipeFindTotalPage(map);
	}
	
	
}
