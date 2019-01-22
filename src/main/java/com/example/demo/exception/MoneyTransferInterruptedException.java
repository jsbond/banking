package com.example.demo.exception;

public class MoneyTransferInterruptedException extends RuntimeException {
    public MoneyTransferInterruptedException(String message) {
        super(message);
    }
}
