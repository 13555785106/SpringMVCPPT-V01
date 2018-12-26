package com.sample.constraint;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbiesValidator implements ConstraintValidator<Hobbies, String> {
	private final List<String> hobbies = Arrays.asList(new String[] { "足球", "篮球", "排球" });

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if (arg0 == null || arg0.length() == 0)
			return true;
		String[] strs = arg0.split(",");
		for (String hobby : strs) {
			if (!hobbies.contains(hobby))
				return false;
		}
		return true;
	}
}
