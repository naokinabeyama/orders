package com.example.orders.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrderStatusEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.jpa.CompaniesJpa;
import com.example.orders.jpa.OrderStatusJpa;
import com.example.orders.jpa.OrdersJpa;


@Repository
public class OrdersSearchListRepository {
	
	@Autowired
	OrdersJpa ordersjpa;
	
	@Autowired
	OrderStatusJpa orderStatusJpa;
	
	@Autowired
	CompaniesJpa companyJpa;
	
	public List<OrderStatusEntity> selectAll() {
		List<OrderStatusEntity> orderStatusEntity = orderStatusJpa.findAll();
		return orderStatusEntity;
	}
	
	public List<CompaniesEntity> selectCompany() {
		List<CompaniesEntity> company = companyJpa.findAll();
		return company;
	}
	
	public List<OrdersEntity> getId() {
		List<OrdersEntity> id = ordersjpa.findAll();
		return id;
	}
	
	public Page<OrdersEntity> getPage(Specification<OrdersEntity> searchConditions, Pageable pageable){
    Page<OrdersEntity> entityPageList = ordersjpa.findAll(searchConditions, pageable);
    return entityPageList;
	}
}
