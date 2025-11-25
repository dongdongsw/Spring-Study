package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.DeptVO;


/*
	SELECT * FROM dept ORDER BY deptno;
	-- List
	
	SELECT * FROM dept WHERE deptno = 10;
	-- DeptVO
	
	SELECT loc FROM dept WHERE deptno=10;
	-- String
	
	SELECT loc FROM dept;
	-- List<String>
	
	SELECT deptno FROM dept;
	-- List<Integer>
 */
public interface DeptMapper {
	@Select("SELECT * FROM dept ORDER BY deptno")
	public List<DeptVO> deptListData();
}
