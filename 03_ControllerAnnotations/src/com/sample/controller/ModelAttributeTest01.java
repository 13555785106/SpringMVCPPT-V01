package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/modelattributetest01")
public class ModelAttributeTest01 {
	/*被 @ModelAttribute 注解的方法会在Controller每个方法执行之前都执行，
	 * 因此对于一个Controller中包含多个URL的时候，要谨慎使用。
	 */
	@ModelAttribute
    public void myModel(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
    }

    @RequestMapping(value = "/test")
    public String test1() {
        return "ModelAttributeTest";
    }
}
