package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.AccountMoneyTransferRequest;
import com.example.demo.service.AccountValidationService;

@Service
public class AccountValidationServiceImpl implements AccountValidationService {
    public boolean validate(AccountMoneyTransferRequest request) {
        //todo: validate there
        return true;
    }
}
