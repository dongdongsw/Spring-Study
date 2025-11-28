package com.sist.service;

import java.util.List;


import com.sist.vo.DataBoardVO;

public interface DataBoardService {
	
	public List<DataBoardVO> databoardListData(int start);

	public int databoardRowCount();
	
	public void databoardInsert(DataBoardVO vo);
	
	public DataBoardVO databoardDetialData(int no);
	
	public DataBoardVO databoardFileInfoData(int no);
	
	public boolean databoardDelete(int no,String pwd);
	
	public DataBoardVO databoardUpdateData(int no);
	
	public boolean databoardUpdate(DataBoardVO vo);


}
