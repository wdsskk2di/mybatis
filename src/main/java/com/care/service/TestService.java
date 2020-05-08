package com.care.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.dao.TestDAO;

@Service
public class TestService {
	@Autowired
	private TestDAO dao;

	public void test(Model model) {
		model.addAttribute("lists", dao.test());
	}
	
	public void list(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String num = request.getParameter("num");
		
		model.addAttribute("list", dao.list(num));
	}
}
