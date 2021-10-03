package com.example.orders.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.entity.PlacesEntity;
import com.example.orders.jpa.CompaniesJpa;
import com.example.orders.jpa.OrdersJpa;
import com.example.orders.jpa.PlacesJpa;

@Repository
public class OrdersRegistRepository {
	
	@Autowired
	OrdersJpa ordersJpa;
	
	@Autowired
	PlacesJpa placesJpa;
	
	@Autowired
	CompaniesJpa companiesJpa;
	
	public void insertDB(OrdersEntity entity) {
		ordersJpa.save(entity);
	}
	
	public void insertDB(PlacesEntity entity) {
		placesJpa.save(entity);
	}
	
	public List<CompaniesEntity> selectAll() {
		List<CompaniesEntity> companiesEntityList = companiesJpa.findAll();
		return companiesEntityList;
	}
}
