package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelattributetest03")
public class ModelAttributeTest03 {
	@RequestMapping(value = "/test")
	public String test1(@ModelAttribute("name") String str1, @ModelAttribute("sex") String str2,
			@ModelAttribute("age") String str3) {
		return "ModelAttributeTest";
	}
}
