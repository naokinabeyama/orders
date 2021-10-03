package com.example.orders.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrderStatusEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.form.SearchForm;
import com.example.orders.service.OrdersSearchListService;


@Controller
public class OrdersSearchListController {
	
	@Autowired
	OrdersSearchListService service;
	
	// 検索一覧
	@RequestMapping("/orders")
	public ModelAndView ordersSearchList (@RequestParam(value="page", defaultValue="0") int pageNum,
			@ModelAttribute("form") @Validated SearchForm form, BindingResult result) {

		ModelAndView mv = new ModelAndView();
		List<OrderStatusEntity> orderStatusEntity = service.getAll();
		List<CompaniesEntity> company = service.getCompany();
		List<OrdersEntity> ordersId = service.getId();
		Page<OrdersEntity> ordersEntityList = null;
		
		if(result.hasErrors()) {
			ordersEntityList = service.getPage(pageNum, new SearchForm());
    /* not error */
    } else {
    	ordersEntityList = service.getPage(pageNum, form);
     }
		
		List<String> date = service.getDate(ordersEntityList);
		
		mv.addObject("ordersId", ordersId);
		mv.addObject("company", company);
		mv.addObject("date", date);
		mv.addObject("form", form);
		mv.addObject("orderStatusEntity", orderStatusEntity);
		mv.addObject("entityList", ordersEntityList);
		mv.setViewName("ordersSearchList.html");
    return mv;
	}
}
