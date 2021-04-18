package com.heytusar.hellospring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("greeting", request.getParameter("greeting"));
		List<String> tasks = new ArrayList<String>();
		tasks.add("Eat");
		tasks.add("Sleep");
		tasks.add("Code");
		model.addAttribute("tasks", tasks);
		return "index";
	}
}
