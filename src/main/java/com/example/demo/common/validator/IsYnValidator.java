package com.example.demo.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsYnValidator implements ConstraintValidator<IsYn, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) s = "";
        // 빈 값이어도 매치
        return s.matches("^[YN]?$");
    }
}
