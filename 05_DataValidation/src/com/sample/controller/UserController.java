package com.sample.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sample.model.User;
import com.sample.model.UserDatas;
import com.sample.utilities.Paging;
import com.sample.validator.UserValidator;

import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class UserController {
	@InitBinder
	public void InitBinder(WebDataBinder binder) {

	}

	@RequestMapping("/user_input/{id}")
	public String inputUser(Model model, @PathVariable String id) {

		User user = UserDatas.getInstance().getUser(id);
		if (user == null) {
			user = new User();
			user.setSex("女");
			user.setHobbies("篮球,排球");
		}
		model.addAttribute(user);
		return "UserForm";
	}

	@RequestMapping(value = "/user_save")
	public String saveUser(@ModelAttribute User user, BindingResult bindingResult) {
		System.out.println(user);
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);
		if (!user.getConfirmPasswd().equals(user.getPasswd())) {
			bindingResult.addError(
					new FieldError("user", "confirmPasswd", user.getConfirmPasswd(), true, null, null, "确认密码与密码不等"));
		}
		if (bindingResult.hasErrors()) {
			return "UserForm";
		}
		boolean success = false;
		String action = "添加";
		if (user.getId() == null || user.getId().isEmpty()) {
			user.setId(UUID.randomUUID().toString());
			success = UserDatas.getInstance().addUser(user);
		} else {
			action = "修改";
			success = UserDatas.getInstance().chgUser(user);
		}
		if (!success) {
			if (action.equals("添加"))
				user.setId("");
			bindingResult.addError(new ObjectError("user", action + "用户失败！"));
			return "UserForm";
		}
		return "redirect:/user_list";
	}

	/*
	 * @RequestMapping(value = "/user_save") public String
	 * saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
	 * if(!user.getConfirmPasswd().equals(user.getPasswd())) {
	 * bindingResult.addError(new
	 * FieldError("user","confirmPasswd",user.getConfirmPasswd(),true,null,null,
	 * "确认密码与密码不等")); } if (bindingResult.hasErrors()) { for (ObjectError oe :
	 * bindingResult.getAllErrors()) { System.out.println(oe.getClass()); } for
	 * (ObjectError oe : bindingResult.getGlobalErrors()) {
	 * System.out.println(oe.getClass()); } return "UserForm"; } boolean success =
	 * false; String action = "添加"; if (user.getId() == null ||
	 * user.getId().isEmpty()) { user.setId(UUID.randomUUID().toString()); success =
	 * UserDatas.getInstance().addUser(user); } else { action = "修改"; success =
	 * UserDatas.getInstance().chgUser(user); } if (!success) { if
	 * (action.equals("添加")) user.setId(""); bindingResult.addError(new
	 * ObjectError("user", action + "用户失败！")); return "UserForm"; } return
	 * "redirect:/user_list"; }
	 */
	@RequestMapping(value = "/user_list")
	public String listUser(HttpServletRequest request, Model model) {
		String account = request.getParameter("account");
		if (account == null)
			account = "";
		account = account.trim();

		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr == null)
			pageNoStr = "0";
		int pageNo = Integer.parseInt(pageNoStr);

		String pageSizeStr = request.getParameter("pageSize");
		if (pageSizeStr == null)
			pageSizeStr = "10";
		int pageSize = Integer.parseInt(pageSizeStr);

		if (request.getParameter("lastPage") != null)
			pageNo = Integer.MAX_VALUE;
		if (request.getParameter("firstPage") != null)
			pageNo = 0;
		if (request.getParameter("previousPage") != null)
			pageNo--;
		if (request.getParameter("nextPage") != null)
			pageNo++;
		List<User> list = UserDatas.getInstance().getDatas();
		if (!account.isEmpty()) {
			final String str = account;
			list = UserDatas.getInstance().getDatas().stream().filter(o -> o.getAccount().contains(str))
					.collect(Collectors.toList());
		}
		Paging<User> paging = new Paging<User>(pageSize, pageNo, list);
		model.addAttribute("paging", paging);
		model.addAttribute("account", account);
		return "UserList";
	}
}
