package com.example.orders.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.orders.entity.PlacesEntity;

public interface PlacesJpa extends JpaRepository<PlacesEntity, Integer>{
	
}
