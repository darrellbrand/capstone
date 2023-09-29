package com.example.demo.validators;

import com.example.demo.domain.Guitar;
import com.example.demo.domain.GuitarPart;
import com.example.demo.service.GuitarService;
import com.example.demo.service.GuitarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Guitar> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;

    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Guitar guitar, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) return true;
        if (context != null) myContext = context;
        GuitarService repo = myContext.getBean(GuitarServiceImpl.class);
        if (guitar.getId() != 0) {
            Guitar myGuitar = repo.findById((int) guitar.getId());

            for (GuitarPart p : myGuitar.getParts()) {
                if ((p.getInv() < (guitar.getInv() - myGuitar.getInv())) || (p.getMinInv() > (p.getInv() - (guitar.getInv() - myGuitar.getInv())))) return false;
            }

            return true;
        } else {

            return true;
        }
    }
}
