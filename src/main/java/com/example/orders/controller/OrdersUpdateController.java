package com.example.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.entity.OrdersEntity;
import com.example.orders.form.UpdateForm;
import com.example.orders.service.OrdersUpdateService;



@Controller
public class OrdersUpdateController {
	
	@Autowired
	OrdersUpdateService service;
	
	// 更新画面
	@RequestMapping("orders/update")
	public ModelAndView ordersUpdate(@RequestParam("ordersId") int id,
			 UpdateForm form) {
		ModelAndView mv = new ModelAndView();
		
		OrdersEntity ordersEntity = service.getRecord(id);
		List<CompaniesEntity> company = service.getCompany();
		
		mv.addObject("company", company);
		mv.addObject("orders", ordersEntity);
		mv.setViewName("/ordersUpdate.html");
		return mv;
	}
	
	
	// 更新処理
	@RequestMapping("orders/doUpdate")
	public ModelAndView doUpdate(UpdateForm form, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView();
		// attributes.addAttribute("ordersId", form.getOrderId());
		service.update(form);
		mv.setViewName("redirect:/orders/update");
		return mv;
	}
}
