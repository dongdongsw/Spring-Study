package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Controller
@RequestMapping("food/")
public class FoodController {

	@Autowired
	private FoodDAO dao;
	
	@GetMapping("list.do")
	public String food_list(String page, Model model) {
		
		if(page==null) {
			page="1";
		}
		//
		int curpage = Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		List<FoodVO> list = dao.foodListData(start, end);
		int totalpage = dao.foodTotalData();
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		
		return "food/list";
	}
}
