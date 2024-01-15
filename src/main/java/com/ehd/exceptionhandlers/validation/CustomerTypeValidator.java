package com.ehd.exceptionhandlers.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class CustomerTypeValidator implements ConstraintValidator<ValidateCustomerType, String> {

    @Override
    public boolean isValid(String customer, ConstraintValidatorContext constraintValidatorContext) {
        List<String> customerTypes = Arrays.asList("Meuble", "Electronics", "Computer");
        return customerTypes.contains(customer);
    }
}
