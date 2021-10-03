package com.example.orders.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.entity.PlacesEntity;
import com.example.orders.form.RegistForm;
import com.example.orders.repository.OrdersRegistRepository;

@Service
public class OrdersRegistService {
	
	@Autowired
	OrdersRegistRepository ordersRegistRepository;
	
	/* データベースに登録 */
	public void insertDB(RegistForm form) {
		// placesテーブルに登録
		PlacesEntity placesEntity = new PlacesEntity();
		
		placesEntity.setCompanyId(form.getCompanyId());
		placesEntity.setPlaceItemName(form.getPlaceItemName());
		placesEntity.setPlaceQuantity(Integer.parseInt(form.getPlaceQuantity()));
		placesEntity.setPlaceItemPrice(Integer.parseInt(form.getPlaceItemPrice()));
		
		ordersRegistRepository.insertDB(placesEntity);
		
		// ordersテーブルに登録
		OrdersEntity ordersEntity = new OrdersEntity();
		
		ordersEntity.setPlaceId(placesEntity.getId());
		ordersEntity.setStatusCode(1);
		ordersEntity.setClientName(form.getClientName());
		ordersEntity.setAddress(form.getAddress());
		ordersEntity.setTell(form.getTell());
		ordersEntity.setItemName(form.getItemName());
		ordersEntity.setPrice(Integer.parseInt(form.getItemPrice()));
		ordersEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		ordersEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		ordersRegistRepository.insertDB(ordersEntity);
	}
	
	public List<CompaniesEntity> getAll() {
		List<CompaniesEntity> companiesEntityList = ordersRegistRepository.selectAll();
		return companiesEntityList;
	}
	
//	public List<String> getCompanyIdList() {
//		List<CompaniesEntity> reservationsEntityList = managerservice.getAll();
//	}
}
