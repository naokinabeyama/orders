package com.example.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.orders.entity.CompaniesEntity;
import com.example.orders.form.RegistForm;
import com.example.orders.service.OrdersRegistService;

@Controller
public class OrdersRegistController {
	
	@Autowired
	OrdersRegistService ordersRegistService;
	
	/* 登録画面の表示 */
	@GetMapping("/orders/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		List<CompaniesEntity> companiesEntityList = ordersRegistService.getAll();
		mv.addObject("companiesEntityList", companiesEntityList);
		mv.setViewName("/ordersRegist.html");
		return mv;
	}
	
	/* 登録処理 */
	@PostMapping("/orders/doRegister")
	public ModelAndView doInsert(@ModelAttribute("form") @Validated RegistForm form, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		
		if (result.hasErrors()) {
			List<CompaniesEntity> companiesEntityList = ordersRegistService.getAll();
			mv.addObject("companiesEntityList", companiesEntityList);
			mv.setViewName("/ordersRegist.html");
		} else {
			ordersRegistService.insertDB(form);
			mv.setViewName("redirect:/orders");
		}

		return mv;
	}
}
