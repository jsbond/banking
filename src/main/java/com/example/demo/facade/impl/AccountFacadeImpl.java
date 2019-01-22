package com.example.demo.facade.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Wallet;
import com.example.demo.dto.AccountMoneyTransferDTO;
import com.example.demo.dto.request.AccountMoneyTransferRequest;
import com.example.demo.exception.CreatePaymentTokenException;
import com.example.demo.exception.InvalidMoneyTransferRequestException;
import com.example.demo.exception.MoneyTransferInterruptedException;
import com.example.demo.exception.MoneyTransferTimeoutException;
import com.example.demo.facade.AccountFacade;
import com.example.demo.service.AccountValidationService;
import com.example.demo.service.CustomerService;
import com.example.demo.synchronizer.impl.AccountSynchronizationService;
import com.example.demo.utils.AccountMoneyTransferStatus;

@Service
@Transactional
public class AccountFacadeImpl implements AccountFacade {
    @Autowired
    private AccountValidationService accountValidationService;
    @Autowired
    private AccountSynchronizationService accountSynchronizationService;
    @Autowired
    private CustomerService customerService;


    public AccountMoneyTransferDTO transferMoneyToCustomerWallet(AccountMoneyTransferRequest request) {
        boolean isValidRequest = accountValidationService.validate(request);

        if (!isValidRequest) {
            throw new InvalidMoneyTransferRequestException("invalid request: " + request);
        }

        ReentrantLock lock = accountSynchronizationService.getLock(request.getAccountId());

        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Customer customer = customerService.findById(request.getCustomerId());

                Account account = customer.getAccount();
                account.setAmount(account.getAmount().subtract(request.getAmountToTransfer()));

                Wallet wallet = customer.getWallet();
                wallet.setAmount(wallet.getAmount().add(request.getAmountToTransfer()));


            } else {
                throw new MoneyTransferTimeoutException("money transfer timed out for request " + request);
            }
        } catch (InterruptedException e) {
            throw new MoneyTransferInterruptedException("money transfer was interrupted for request " + request);
        }

        AccountMoneyTransferDTO response = new AccountMoneyTransferDTO();
        response.setStatus(AccountMoneyTransferStatus.SUCCESS);

        return response;
    }
}
