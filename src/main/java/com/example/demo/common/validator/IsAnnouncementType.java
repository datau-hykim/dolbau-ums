package com.example.demo.common.validator;

import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsAnnouncementTypeValidator.class)
public @interface IsAnnouncementType {
    String message() default "주어지지 않거나, H 또는 E가 입력되어야 합니다.";
    Class[] groups() default {};
    Class[] payload() default {};
}
