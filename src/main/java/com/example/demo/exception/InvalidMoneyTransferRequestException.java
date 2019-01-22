package com.example.demo.exception;

public class InvalidMoneyTransferRequestException extends RuntimeException {
    public InvalidMoneyTransferRequestException(String message) {
        super(message);
    }
}
