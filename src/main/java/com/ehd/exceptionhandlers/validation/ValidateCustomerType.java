package com.ehd.exceptionhandlers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention((RetentionPolicy.RUNTIME))
@Documented
@Constraint(validatedBy = CustomerTypeValidator.class)
public @interface ValidateCustomerType {

    public String message() default "Invalid customerType : It should be either Computer OR Electronics OR Meuble";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
