package com.example.demo.service;

import com.example.demo.dto.request.AccountMoneyTransferRequest;

public interface AccountValidationService {
    boolean validate(AccountMoneyTransferRequest request);
}
