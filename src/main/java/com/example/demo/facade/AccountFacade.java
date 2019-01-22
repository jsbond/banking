package com.example.demo.facade;

import com.example.demo.dto.AccountMoneyTransferDTO;
import com.example.demo.dto.request.AccountMoneyTransferRequest;

public interface AccountFacade {
    AccountMoneyTransferDTO transferMoneyToCustomerWallet(AccountMoneyTransferRequest request);
}
