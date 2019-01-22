package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountMoneyTransferDTO;
import com.example.demo.dto.request.AccountMoneyTransferRequest;
import com.example.demo.facade.AccountFacade;

@RestController("/account")
public class AccountMoneyTransferController {

    @Autowired
    private AccountFacade accountFacade;

    @PatchMapping("/withdraw")
    public AccountMoneyTransferDTO transferMoneyToCustomerWallet(@RequestBody AccountMoneyTransferRequest request) {
        return accountFacade.transferMoneyToCustomerWallet(request);
    }
}
