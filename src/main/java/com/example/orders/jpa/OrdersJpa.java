package com.example.orders.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.orders.entity.OrdersEntity;


public interface OrdersJpa extends JpaRepository<OrdersEntity, Integer>,
	JpaSpecificationExecutor<OrdersEntity>{
	
}
