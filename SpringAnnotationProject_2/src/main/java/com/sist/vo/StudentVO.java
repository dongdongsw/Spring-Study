package com.sist.vo;

import lombok.Data;

/*
 HAKBUN NOT NULL NUMBER       
NAME   NOT NULL VARCHAR2(50) 
KOR             NUMBER(3)    
ENG             NUMBER(3)    
MATH            NUMBER(3)   
 */
@Data
public class StudentVO {
	private int hakbun, kor, eng, math;
	private String name;
}
