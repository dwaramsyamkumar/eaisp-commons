package com.ob.eaisp.commons.validators;


import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = NotEmptyIfPresent.NotEmptyIfPresentValidator.class)
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface NotEmptyIfPresent {

    String message() default "Incorrect enum value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class NotEmptyIfPresentValidator implements ConstraintValidator<NotEmptyIfPresent, List<?>> {
        @Override
        public boolean isValid(List<?> value, ConstraintValidatorContext context) {
            return value == null || !CollectionUtils.isEmpty(value);
        }
    }
}
