package com.FetchNextNumber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FetchNextNumber.model.Num;
import com.FetchNextNumber.service.NumServiceInterface;

@RestController
public class FetchController {
	@Autowired
	private NumServiceInterface numServiceInterface;
	
	
	@PutMapping("/FetchNextNumber/{CategoryCode}")
	public Num fetchNextNumber(@PathVariable Long CategoryCode) {
		return numServiceInterface.updateNum(CategoryCode);		
	}
	
}
