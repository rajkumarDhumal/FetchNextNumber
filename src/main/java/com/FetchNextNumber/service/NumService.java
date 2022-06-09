package com.FetchNextNumber.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.FetchNextNumber.exception.BusinessException;
import com.FetchNextNumber.model.Num;
import com.FetchNextNumber.repository.FetchRepository;

public class NumService implements NumServiceInterface{
	
	@Autowired
	private FetchRepository fetchRepository;
	
	@Override
	public Num getNumById(Long CategoryCode) {
		try {
			return fetchRepository.findById(CategoryCode).get();		
		}catch (IllegalArgumentException e) {
			throw new BusinessException("606","given CategoryCode is null, please send some CategoryCode to be searched" + e.getMessage());
		}
		catch (java.util.NoSuchElementException e) {
			throw new BusinessException("607","given CategoryCode doesnot exist in DB" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("609","Something went wrong in Service layer while fetching Num" + e.getMessage());
		}
		
	}

	@Override
	public void updateNum(Long CategoryCode, Num numDetaila) {
		
	}

}
