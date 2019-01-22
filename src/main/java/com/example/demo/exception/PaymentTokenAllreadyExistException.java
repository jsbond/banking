package com.example.demo.exception;

public class PaymentTokenAllreadyExistException extends RuntimeException {
    public PaymentTokenAllreadyExistException(String message) {
        super(message);
    }
}
