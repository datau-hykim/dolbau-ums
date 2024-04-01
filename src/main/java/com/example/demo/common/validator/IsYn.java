package com.example.demo.common.validator;

import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsYnValidator.class)
public @interface IsYn {
    String message() default "Y 또는 N이 입력되어야 합니다.";
    Class[] groups() default {};
    Class[] payload() default {};
}
