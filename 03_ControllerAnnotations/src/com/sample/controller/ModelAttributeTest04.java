package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modelattributetest04")
/*返回值 String （或者其他对象），就不再是视图，而是放到Model中的值。
 * 对于映射，而是使用的默认视图映射。
 * */
public class ModelAttributeTest04 {
	@RequestMapping(value = "/test")
    @ModelAttribute("name")
    public String test1(@RequestParam(required = false) String name) {
        return name;
    }
}
