package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Constraint(validatedBy = {NotEnoughPartsValidator.class})
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidNotEnoughParts {
        String message() default "There are not enough parts in inventory!";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }


