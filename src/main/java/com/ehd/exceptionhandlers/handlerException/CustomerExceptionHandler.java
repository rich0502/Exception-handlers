package com.ehd.exceptionhandlers.handlerException;

import com.ehd.exceptionhandlers.dtos.ErrorDto;
import com.ehd.exceptionhandlers.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ErrorDto HandlerCustomerNotFoundException(CustomerNotFoundException ex){
        return ErrorDto.builder()
                .status("Failled")
                .ErrorMessage(ex.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
