package com.sist.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.RecipeDAO;
import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 레시피 선택(1. 제목, 2. 세프)");
		 
		String[] recipe = {"", "title", "chef"};
		
		int num = scan.nextInt();
		String column ="";
		String ss = scan.next();
		
		Map map = new HashMap();
		map.put("column", recipe[num]);
		map.put("ss", ss);
		 
		RecipeService rs = (RecipeService)app.getBean("recipeServiceImpl");
		List<RecipeVO> list = rs.RecipeListData(map);
		int count = rs.RecipeListCount(map);
		
	    System.out.println("검색 결과:"+count+"건");
		for(RecipeVO vo : list) {
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("세프 : " + vo.getChef());
			System.out.println();
		}
	}
}
