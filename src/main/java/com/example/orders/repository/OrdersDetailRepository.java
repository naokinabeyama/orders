package com.example.orders.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.orders.entity.OrdersEntity;
import com.example.orders.jpa.OrdersJpa;

@Repository
public class OrdersDetailRepository {
	
	@Autowired
	OrdersJpa ordersJpa;
	
	public OrdersEntity getRecord(int id) {
		OrdersEntity ordersEntity = ordersJpa.getOne(id);
		return ordersEntity;
	}
	
	public void create(OrdersEntity entity) {
		ordersJpa.save(entity);
	}
	
	public void delete(int id) {
		ordersJpa.deleteById(id);
	}
}
