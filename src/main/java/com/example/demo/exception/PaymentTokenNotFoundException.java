package com.example.demo.exception;

public class PaymentTokenNotFoundException extends RuntimeException {
    public PaymentTokenNotFoundException(String message) {
        super(message);
    }
}
