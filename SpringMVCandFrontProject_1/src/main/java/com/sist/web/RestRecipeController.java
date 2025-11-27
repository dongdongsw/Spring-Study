package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

// 화면 제어(X) => Front로 데이터 전송
// => 1. 일반 문자열 , 2. 정수 , 3. JSON
// => JSON을 자동으로 구현

@RestController
public class RestRecipeController {
	/*
	@GetMapping(value = "emp/list.do",produces="text/plain;charset=UTF-8")
	// @GetMapping("emp/list.do")
	// @GetMapping(value = "emp/list.do", produces = "application/json;charset=UTF-8")
	public String emp_list() throws Exception {
		
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		list.add(new EmpVO(1,"홍길동1","개발부"));
		list.add(new EmpVO(2,"홍길동2","개발부"));
		list.add(new EmpVO(3,"홍길동3","개발부"));
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
        
        return json;   // ✔ JSON 문자열 정상 반환
	}
	*/
	
	@Autowired
	private RecipeService service;
	
	@GetMapping(value="recipe/list_vue.do",produces="text/plain;charset=UTF-8")
	public String recipe_list_Vue(int page) throws Exception{
	
		int curpage = page;
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		List<RecipeVO> list = service.recipeListData(start, end);
		int totalpage=service.recipeTotalPage();
		
		final int BLOCK=10;
		/*
		 * 		1	2	3	4	5	6	7	8	9	10 >
		 */
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		Map map = new HashMap();
		map.put("curpage", curpage);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		return json;
		
	}
}
