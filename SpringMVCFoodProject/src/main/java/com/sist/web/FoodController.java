package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

@Controller
@RequestMapping("food/")
public class FoodController {

	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private FoodService service;
	
	@GetMapping("list.do")
	public String food_list(String page, Model model) {
		
		if(page==null) {
			page="1";
		}
		//
		int curpage = Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		List<FoodVO> list = dao.foodListData(start, end);
		int totalpage = dao.foodTotalData();
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		
		return "food/list";
	}
	
	@RequestMapping("find.do")
	public String food_find(String page,String address, Model model) {
		
		if(page==null) {
			page="1";
		}
		if(address==null) {
			address="마포";
		}
		
		//
		int curpage = Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		
		Map map = new HashMap();
		map.put("address", address);
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> list = service.foodFindData(map);
		int totalpage = service.foodFindTotalData(address);
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("address",address);
		
		return "food/find";
	}
}
