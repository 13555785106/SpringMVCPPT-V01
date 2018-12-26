package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/sessionattributestest")
@SessionAttributes("pi")
public class SessionAttributesTest {
	@GetMapping(value = "sessionAttributes1")
	public String sessionAttributes(Model model) {
		
		model.addAttribute("pi", Math.PI);
		model.addAttribute("name", "肖俊峰");
		return SessionAttributesTest.class.getSimpleName();
	}
	@GetMapping(value="sessionAttributes2")
    public String sessionAttributes(@ModelAttribute("pi") Double pi){
        System.out.println(pi);
        return SessionAttributesTest.class.getSimpleName();
    }
}
