package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Controller
@RequestMapping("recipe/")
public class RecipeController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping("list.do")
	public String recipe_list(String page, Model model) {
		
		
		if(page==null) {
			page="1";
		}
		//
		int curpage = Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		
		List<RecipeVO> list = dao.recipeListData(start, end);
		int totalpage = dao.recipeTotalPage();	
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		
		return "recipe/list";
	}
}
