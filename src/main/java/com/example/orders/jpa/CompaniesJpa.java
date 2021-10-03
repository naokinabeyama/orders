package com.example.orders.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orders.entity.CompaniesEntity;


public interface CompaniesJpa extends JpaRepository<CompaniesEntity, Integer>{
	
}
