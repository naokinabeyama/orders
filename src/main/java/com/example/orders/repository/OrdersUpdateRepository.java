package com.example.orders.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.jpa.CompaniesJpa;
import com.example.orders.jpa.OrdersJpa;

@Repository
public class OrdersUpdateRepository {
	
	@Autowired
	OrdersJpa ordersJpa;
	
	@Autowired
	CompaniesJpa companyJpa;
	
	public OrdersEntity getRecord(int id) {
		OrdersEntity ordersEntity = ordersJpa.getOne(id);
		return ordersEntity;
	}
	
	public List<CompaniesEntity> getCompany() {
		List<CompaniesEntity> company = companyJpa.findAll();
		return company;
	}
	
	public void update(OrdersEntity ordersEntity) {
		ordersJpa.save(ordersEntity);
	}
}
