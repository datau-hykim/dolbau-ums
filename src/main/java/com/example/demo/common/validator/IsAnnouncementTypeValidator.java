package com.example.demo.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsAnnouncementTypeValidator implements ConstraintValidator<IsAnnouncementType, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return true;
        if (s.isEmpty()) return true;

        return s.matches("^[HE]$");
    }
}
