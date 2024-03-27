package com.example.demo.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

public class DuConstraint {

    /**
     * Constraint 결합 예시
     * Not Null, 2 <= Length <= 20
     */
    @NotNull
    @Size(min=2, max=20)
    @Target({ METHOD, FIELD, ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = { })
    @Documented
    public @interface NotNullAndBetween2And20 {
        String message() default "";
        Class<?>[] groups() default { };
        Class<? extends Payload>[] payload() default { };
    }

    /**
     * Custom Constraint 예시
     * 필드가 BoardPlatformCode 에 속하는가?
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = { BoardPlatformCodeValidator.class })
    @Documented
    public @interface BoardPlatformCode {
        String message() default "없는 코드 값이 요청되었습니다";
        Class<?>[] groups() default { };
        Class<? extends Payload>[] payload() default { };
    }

    private static class BoardPlatformCodeValidator implements ConstraintValidator<BoardPlatformCode, String> {
        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            com.example.demo.constant.BoardPlatformCode code = com.example.demo.constant.BoardPlatformCode
                    .findCodeByKey(s)
                    .orElse(null);

            return code != null;
        }
    }
}