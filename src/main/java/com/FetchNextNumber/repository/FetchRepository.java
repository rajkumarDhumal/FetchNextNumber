package com.FetchNextNumber.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FetchNextNumber.model.Num;

public interface FetchRepository extends JpaRepository<Num, Long> {
	
	
}
