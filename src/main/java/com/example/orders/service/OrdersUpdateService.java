package com.example.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.form.UpdateForm;
import com.example.orders.repository.OrdersUpdateRepository;

@Service
public class OrdersUpdateService {
	
	
	@Autowired
	OrdersUpdateRepository repository;
	
	
	public OrdersEntity getRecord(int id) {
		OrdersEntity ordersEntity = repository.getRecord(id);
		return ordersEntity;
	}
	
	public List<CompaniesEntity> getCompany() {
		List<CompaniesEntity> company = repository.getCompany();
		return company;
	}
	
	public void update(UpdateForm form) {
		
		OrdersEntity ordersEntity = repository.getRecord(form.getOrderId());
		
		
		String[] idName = form.getCompanyId().split(":");
		int id = Integer.parseInt(idName[0]);
		
		
		
		ordersEntity.setClientName(form.getClientName());
		ordersEntity.setTell(form.getTell());
		ordersEntity.setAddress(form.getAddress());
		ordersEntity.setItemName(form.getItemName());
		ordersEntity.setPrice(form.getItemPrice());
		ordersEntity.getPlacesEntity().getCompaniesEntity().setCompanyId(id);
		ordersEntity.getPlacesEntity().getCompaniesEntity().setCompanyName(idName[1]);
		ordersEntity.getPlacesEntity().setPlaceItemName(form.getPlaceItemName());
		ordersEntity.getPlacesEntity().setPlaceQuantity(form.getPlaceQuantity());
		ordersEntity.getPlacesEntity().setPlaceItemPrice(form.getPlaceItemPrice());
		repository.update(ordersEntity);
	}
	
	
}
