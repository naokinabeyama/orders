package com.example.orders.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orders.entity.OrderStatusEntity;

public interface OrderStatusJpa extends JpaRepository<OrderStatusEntity, Integer>{
	
}
