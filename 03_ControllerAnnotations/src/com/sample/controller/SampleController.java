package com.sample.controller;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sample.model.Product;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {

	@RequestMapping(value = "/Sample01")
	public String sample01(int age, double salary, Model model) {

		model.addAttribute("age", age);
		model.addAttribute("salary", salary);
		return "sample/Sample01";
	}

	@RequestMapping(value = "/Sample02")
	public String sample02(Integer age, Double salary, Model model) {
		model.addAttribute("age", age);
		model.addAttribute("salary", salary);
		return "sample/Sample02";
	}

	@RequestMapping(value = "/Sample03")
	public String sample03(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date birthday, Model model) {
		model.addAttribute("birthday", birthday);
		return "sample/Sample03";
	}

	@RequestMapping(value = "/Sample04")
	public String sample04(@ModelAttribute Product product, BindingResult bindingResult) {
		System.out.println(bindingResult);
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			System.out.println(fieldError.getField());
			System.out.println(fieldError.getCode());
			System.out.println(fieldError.getDefaultMessage());
			System.out.println(fieldError.getRejectedValue());
		}
		System.out.println(product);
		return "sample/Sample04";
	}
	@RequestMapping(value = "/Sample05")
	public String sample05(Model model1, Map model2, ModelMap model3) {
	    model1.addAttribute("a", "a");
	    model2.put("b", "b");
	    model3.put("c", "c");
	    System.out.println(model1.getClass().getName());
	    System.out.println(model2.getClass().getName());
	    System.out.println(model3.getClass().getName());
	    return "sample/Sample05";
	}
}
