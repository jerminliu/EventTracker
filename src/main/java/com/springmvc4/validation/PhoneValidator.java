package com.springmvc4.validation;


import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {


    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    //this method performs the actual validation for phone
    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(phoneField))
            return true;
        return phoneField.matches("(\\(\\d+\\))?\\d+");
    }
}
