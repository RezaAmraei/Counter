package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
@RequestMapping("/")
public String index(HttpSession session) {
	if(session.getAttribute("count") == null) {
		session.setAttribute("count", 0);
	}else {
		Integer tempCount = (Integer) session.getAttribute("count");
		tempCount++;
		session.setAttribute("count", tempCount);
		
		
	}
	return "index.jsp";
}
@GetMapping("/setCount")
public String setCount(HttpSession session, Model model) {

	Integer tempCount = (Integer) session.getAttribute("count");
	model.addAttribute("count", tempCount);
	
	return "count.jsp";
}
}
