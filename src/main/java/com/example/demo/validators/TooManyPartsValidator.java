package com.example.demo.validators;

import com.example.demo.domain.GuitarPart;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TooManyPartsValidator implements ConstraintValidator<ValidTooManyParts, GuitarPart> {
    @Override
    public void initialize(ValidTooManyParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(GuitarPart guitarPart, ConstraintValidatorContext constraintValidatorContext) {
        if (guitarPart.getInv()  > guitarPart.getMaxInv()) return false;
        else return true;
    }

}
