package com.ehd.exceptionhandlers.exception;

public class DupicateCustomerException extends RuntimeException{

    public DupicateCustomerException(String message) {
        super(message);
    }
}
