package com.ehd.exceptionhandlers.handlerException;

import com.ehd.exceptionhandlers.dtos.ErrorDto;
import com.ehd.exceptionhandlers.exception.DupicateCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DuplicateExceptionHandler {

    @ExceptionHandler(DupicateCustomerException.class)
    public ProblemDetail handlerDuplicatedException(DupicateCustomerException ex){
//        return ErrorDto.builder()
//                .status("Failled")
//                .ErrorMessage(ex.getMessage())
//                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
//                .build();
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handlerArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().
                forEach(error -> {
                    errorMap.put(error.getField(),error.getDefaultMessage());
                });
        return errorMap;
    }
}
