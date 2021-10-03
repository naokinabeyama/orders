package com.example.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.orders.entity.OrdersEntity;
import com.example.orders.service.OrdersDetailService;

@Controller
public class OrdersDetailController {
	
	
	@Autowired
	OrdersDetailService service;
	
	// 詳細画面
	@RequestMapping("/orders/detail")
	public ModelAndView detail(@RequestParam("ordersId") int id) {
		ModelAndView mv = new ModelAndView();
		OrdersEntity ordersEntity = service.getRecord(id);
		boolean bool = service.getButton(ordersEntity.getStatusCode());
		String date = service.createDate(ordersEntity.getCreatedAt());
		String update = service.createDate(ordersEntity.getUpdatedAt());
		
		mv.addObject("date", date);
		mv.addObject("update", update);
		mv.addObject("bool", bool);
		mv.addObject("orders", ordersEntity);
		mv.setViewName("/ordersDetail.html");
		return mv;
	}
	
	// 削除
	@RequestMapping("/orders/doDelete")
	public ModelAndView doDelete(@RequestParam("ordersId") int id) {
		ModelAndView mv = new ModelAndView();
		service.delete(id);
		mv.setViewName("redirect:/orders");
		return mv;
	}
	
	// 受注確定
	@RequestMapping("/orders/fix")
	public ModelAndView doCreate(RedirectAttributes attributes, @RequestParam("ordersId") int id) {
		ModelAndView mv = new ModelAndView();
		OrdersEntity ordersEntity = service.getRecord(id);
		service.create(ordersEntity);
		attributes.addAttribute("ordersId", id);
		mv.setViewName("redirect:/orders/detail");
		return mv;
	}
}
