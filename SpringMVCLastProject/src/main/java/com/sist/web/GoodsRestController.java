package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.GoodsService;
import com.sist.vo.GoodsVO;

// VueJS => 데이터 전송
@RestController
// RestFul : 다른 프로그램과 연동 (JavaScript)
// @GetMapping(SELECT) / @PostMapping(INSERT) / @PutMapping(UPDATE) / 
// => web : @GetMapping(SELECT) / @PostMapping(INSERT) 
// @RequestMapping(통합) -> Spring 6 => 제거
@CrossOrigin(origins = "*")
public class GoodsRestController {

	@Autowired
	private GoodsService gService;
	
	// 사용자 요청에 따라서 요청 처리
	// -----------URI 주소
	@GetMapping(value="goods/list_vue.do", produces = "text/plain;charset=UTF-8")
	// Bood = >@RestController => text/plain
	public String goods_list_vue(int page)
	{
		int rowSize = 12;
		int start = (rowSize*page)-(rowSize-1);
		int end = rowSize*page;
		List<GoodsVO> list =  gService.goodsListData(start, end);
		int totalpage = gService.goodsTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		Map map = new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalpage", totalpage);
		
		String json ="";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json= mapper.writeValueAsString(map);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return json;
	}
	
	@GetMapping(value="goods/detail_vue.do",produces="text/plain;charset=UTF-8")
	public String goods_detail(int no) {
		
		GoodsVO vo = gService.goodsDetailData(no);
		String strPrice=vo.getGoods_price();
		strPrice = strPrice.replaceAll("[^0-9]", "");
		vo.setPrice(Integer.parseInt(strPrice));
		
		String json = "";
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			json= mapper.writeValueAsString(vo);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return json;
	}
}

