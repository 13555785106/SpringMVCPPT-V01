package com.sample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	@RequestMapping(value="/test_input",method = {RequestMethod.POST,RequestMethod.GET})
	public String inputUser(Model model) {
		Map<String,String> user = new HashMap<String,String>();
		user.put("account", "sss");
		user.put("passwd", "DD");
		user.put("salary", "333");
		model.addAttribute("user",user);
		return "TestInput";
	}
}
