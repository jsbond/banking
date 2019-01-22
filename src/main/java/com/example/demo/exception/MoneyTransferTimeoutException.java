package com.example.demo.exception;

public class MoneyTransferTimeoutException extends RuntimeException {
    public MoneyTransferTimeoutException(String message) {
        super(message);
    }
}
