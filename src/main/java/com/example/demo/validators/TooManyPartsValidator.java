package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TooManyPartsValidator implements ConstraintValidator<ValidTooManyParts, Part> {
    @Override
    public void initialize(ValidTooManyParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv()  > part.getMaxInv()) return false;
        else return true;
    }

}
