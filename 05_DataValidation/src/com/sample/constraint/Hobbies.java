package com.sample.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { HobbiesValidator.class })
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Hobbies {
	String message() default "爱好必须是\"足球\"、\"篮球\"或者\"排球\"";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
