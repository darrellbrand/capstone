package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class NotEnoughPartsValidator implements ConstraintValidator<ValidNotEnoughParts, Part> {
    @Override
    public void initialize(ValidNotEnoughParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(part.getInv()  < part.getMinInv()) return false;
        else return true;
    }
}
