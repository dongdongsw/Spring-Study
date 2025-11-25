package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.DeptDAO;
import com.sist.dao.EmpDAO;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Service	// 비밀번호 암호화 / session 저장 / 자동 로그인
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDAO eDao;
	
	@Autowired
	private DeptDAO dDao;
	
	@Override
	public List<DeptVO> deptListData() {

		return dDao.deptListData();
	}

	@Override
	public List<EmpVO> empListData() {
		
		return eDao.empListData();
	}

	@Override
	public EmpVO empDetailData(int empno) {
		
		return eDao.empDetailData(empno);
	}
	
}
