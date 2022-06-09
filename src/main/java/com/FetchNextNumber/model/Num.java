package com.FetchNextNumber.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Num {

	@Id
	private long CategoryCode;
	private long num;
	
	public long getCategoryCode() {
		return CategoryCode;
	}
	public void setCategoryCode(long categoryCode) {
		CategoryCode = categoryCode;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	
	
}
