package com.example.orders.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orders.entity.OrdersEntity;
import com.example.orders.repository.OrdersDetailRepository;

@Service
public class OrdersDetailService {
	
	@Autowired
	OrdersDetailRepository repository;
	
	// 1件取得
	public OrdersEntity getRecord(int id) {
		OrdersEntity ordersEntity = repository.getRecord(id);
		return ordersEntity;
	}
	
	// 受注確定
	public void create(OrdersEntity ordersEntity) {
		if(ordersEntity.getStatusCode() == 1) {
			ordersEntity.setStatusCode(2);
		}
		repository.create(ordersEntity);
	}
	
	// 非活性
	public boolean getButton(int status) {
		boolean statusCode;
		if(status == 1) {
			statusCode = true;
		} else {
			statusCode = false;
		}
		return statusCode;
	}
	
	// 削除
	public void delete(int id) {
		repository.delete(id);
	}
	
	public String createDate(Timestamp time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String date = sdf.format(time);
		return date;
	}

}
