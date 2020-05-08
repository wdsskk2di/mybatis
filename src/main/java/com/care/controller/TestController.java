package com.care.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.service.TestService;

@Controller
public class TestController {
	@Autowired
	TestService service;
	
	@RequestMapping("test")
	public String test(Model model) {
		service.test(model);
		return "test";
	}
	
	@RequestMapping("input")
	public String inputUserNum() {
		return "inputUserNum";
	}
	
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest re) {
		model.addAttribute("request", re);
		service.list(model);
		
		return "list";
	}
}
