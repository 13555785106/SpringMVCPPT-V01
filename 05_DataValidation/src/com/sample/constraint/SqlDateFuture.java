package com.sample.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { SqlDateFutureValidator.class })
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SqlDateFuture {
	String message() default "必须是今天或者今天以后的日期";

	String value() default "";

	String pattern() default "yyyy-MM-dd";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
