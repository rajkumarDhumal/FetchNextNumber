package com.FetchNextNumber.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FetchNextNumber.exception.BusinessException;
import com.FetchNextNumber.model.Num;
import com.FetchNextNumber.repository.FetchRepository;

@Service
class NumService implements NumServiceInterface{
	
	@Autowired
	private FetchRepository fetchRepository;
	
	@Override
	public Num getNumById(Long CategoryCode) {
		try {
			return fetchRepository.findById(CategoryCode).get();		
		}catch (IllegalArgumentException e) {
			throw new BusinessException("601","given CategoryCode is null, please send some CategoryCode to be searched" + e.getMessage());
		}
		catch (java.util.NoSuchElementException e) {
			throw new BusinessException("602","given CategoryCode doesnot exist in DB" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603","Something went wrong in Service layer while fetching Num" + e.getMessage());
		}
		
	}

	@Override
	public Num updateNum(Long CategoryCode) {
		Num nums=getNumById(CategoryCode);
		
		long num=(nums.getNum()+1);
		long numNext=0;
		int sum=0;
		boolean x=true;
		
		while(x) {
			
			String str=String.valueOf(num);
			while (str.length() > 1)
	        {
	            sum = 0;
	      	    for (int i = 0; i < str.length(); i++)
	                sum += ( str.charAt(i) - '0' ) ;
	      
	            str = sum + "" ;
	        }
			
			if(sum==1) {
				numNext=num;
				x=false;
			}
			num++;
			
		}
		
		nums.setNum(numNext);
		fetchRepository.save(nums);
		
		return nums;		
		
	}

}
