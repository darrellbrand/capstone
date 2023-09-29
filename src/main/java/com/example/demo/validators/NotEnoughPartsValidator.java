package com.example.demo.validators;

import com.example.demo.domain.GuitarPart;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class NotEnoughPartsValidator implements ConstraintValidator<ValidNotEnoughParts, GuitarPart> {
    @Override
    public void initialize(ValidNotEnoughParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(GuitarPart guitarPart, ConstraintValidatorContext constraintValidatorContext) {
        if(guitarPart.getInv()  < guitarPart.getMinInv()) return false;
        else return true;
    }
}
