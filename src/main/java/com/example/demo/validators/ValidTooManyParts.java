package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



    @Constraint(validatedBy = {TooManyPartsValidator.class})
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidTooManyParts {
        String message() default "There are too many parts in inventory!";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
