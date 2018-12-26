package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modelattributetest02")
public class ModelAttributeTest02 {
	@ModelAttribute
	public String myModel(@RequestParam(required = false) String name) {
		return name;
	}
	@ModelAttribute("sex")
	public String myModel() {
		return "男";
	}
	@ModelAttribute
	public int myModel(@RequestParam(required = false) int age) {
		return age;
	}

	@RequestMapping(value = "/test")
	public String test1() {
		return "ModelAttributeTest";
	}
}
