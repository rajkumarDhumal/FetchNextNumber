package com.FetchNextNumber.service;

import com.FetchNextNumber.model.Num;

public interface NumServiceInterface {
	public Num getNumById(Long CategoryCode);
	
	public void updateNum(Long CategoryCode, Num numDetaila);
}
