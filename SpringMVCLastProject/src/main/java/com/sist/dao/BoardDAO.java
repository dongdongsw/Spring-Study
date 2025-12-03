package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

/*
 * 	프로그램
 * 	1. 공통 사용 => 자주 코딩이 되는 부분
 * 	2. 핵심 코딩 => DAO => SQL 
 */

@Repository // 스프링에 관리 대상
public class BoardDAO {

	@Autowired
	private BoardMapper mapper;

	// 어노테이션 => 인덱스 (찾기) => 구분자
	// => if
	/*
	 @Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM springBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM springBoard")
	public int boardRowCount();
	 */
	public List<BoardVO> boardListData(int start, int end){
		return mapper.boardListData(start, end);
	}
	
	public int boardRowCount() {
		return mapper.boardRowCount();
	}

	/*
	 	@Insert("INSERT INTO springBoard VALUES( "
			+ "sb_no_seq.nextval, "
			+ "#{name}, #{subject}, #{content}, #{pwd}, SYSDATE, 0)")
		public void boardInsert(BoardVO vo);
	 */
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}

}
