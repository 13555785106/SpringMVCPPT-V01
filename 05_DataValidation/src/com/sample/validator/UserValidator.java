package com.sample.validator;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sample.model.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (StringUtils.isEmpty(user.getAccount())) {
			ValidationUtils.rejectIfEmpty(errors, "account", "user.account.required");
		} else if (user.getAccount().length() < 2 || user.getAccount().length() > 5) {
			errors.rejectValue("account", "user.account.length", new Object[] { 2, 5 }, null);
		}

		if (StringUtils.isEmpty(user.getPasswd())) {
			ValidationUtils.rejectIfEmpty(errors, "passwd", "user.passwd.required");
		} else if (user.getPasswd().length() < 4 || user.getPasswd().length() > 5) {
			errors.rejectValue("passwd", "user.passwd.length", new Object[] { 4, 5 }, null);
		}

		if (StringUtils.isEmpty(user.getConfirmPasswd())) {
			ValidationUtils.rejectIfEmpty(errors, "confirmPasswd", "user.confirmPasswd.required");
		} else if (user.getConfirmPasswd().length() < 4 || user.getConfirmPasswd().length() > 5) {
			errors.rejectValue("confirmPasswd", "user.confirmPasswd.length", new Object[] { 4, 5 }, null);
		}

		if (user.getSex() != null) {
			if (!Arrays.asList(new String[] { "男", "女" }).contains(user.getSex()))
				errors.rejectValue("sex", "user.sex.error");
		}

		if (user.getBirthday() != null) {
			if (user.getBirthday().getTime() > new java.util.Date().getTime())
				errors.rejectValue("birthday", "user.birthday.error");
		}

		if (user.getSalary() != null && !(user.getSalary() >= 1200 && user.getSalary() <= 50000)) {
			errors.rejectValue("salary", "user.salary.error", new Object[] { 1200, 50000 }, null);
		}
		if (StringUtils.isEmpty(user.getHobbies())) {
			ValidationUtils.rejectIfEmpty(errors, "hobbies", "user.hobbies.required");
		} else {
			for (String hobby : user.getHobbies().split(",")) {
				if (!Arrays.asList(new String[] { "足球", "篮球", "排球" }).contains(hobby))
					errors.rejectValue("hobbies", "user.hobbies.error", new Object[] { "足球", "篮球", "排球" }, null);
			}
		}
	}
}
