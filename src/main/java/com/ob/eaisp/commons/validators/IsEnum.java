package com.ob.eaisp.commons.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

@Documented
@Constraint(validatedBy = IsEnum.IsEnumConstraintValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface IsEnum {
    Class<? extends Enum> value();

    boolean ignoreCase() default true;

    boolean required() default true;

    String message() default "Incorrect enum value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class IsEnumConstraintValidator implements ConstraintValidator<IsEnum, Enum> {
        private Set<String> allowedValues;
        boolean required;

        @Override
        public void initialize(IsEnum targetEnum) {
            Class<? extends Enum> enumSelected = targetEnum.value();

            required = targetEnum.required();
            allowedValues =
                    (Set<String>)
                            EnumSet.allOf(enumSelected).stream()
                                    .map(e -> ((Enum<? extends Enum<?>>) e).name())
                                    .collect(Collectors.toSet());
        }

        @Override
        public boolean isValid(Enum value, ConstraintValidatorContext context) {
            return required
                    && allowedValues.stream()
                    .anyMatch(
                            allowedValue ->
                                    value != null && allowedValue.equals(value.name()));
        }
    }
}