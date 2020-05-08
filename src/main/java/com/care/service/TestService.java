package com.care.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.dao.TestDAO;
import com.care.dto.TestDTO;

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
	
	public void savedata(TestDTO dto) {
		dao.savedata(dto);
	}
	
	public void updatedata(TestDTO dto) {
		dao.updatedata(dto);
	}
	
	//내가 만든 삭제
	public void deletedata(TestDTO dto) {
		dao.deletedata(dto);
	}
	
	//선생님 삭제 코드
	public void delete(String num) {
		dao.delete(num);
	}
}
