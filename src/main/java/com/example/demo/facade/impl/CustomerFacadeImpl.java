package com.example.demo.facade.impl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Customer;
import com.example.demo.exception.CreatePaymentTokenException;
import com.example.demo.facade.CustomerFacade;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerTokenService;
import com.example.demo.synchronizer.impl.AccountSynchronizationService;

@Service
@Transactional
public class CustomerFacadeImpl implements CustomerFacade {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTokenService customerTokenService;

    @Autowired
    private AccountSynchronizationService accountSynchronizationService;

    public String createCustomerToken(Long customerId) {
        Customer customer = customerService.findById(customerId);
        ReentrantLock lock = accountSynchronizationService.getLock(customer.getAccount().getId());

        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                //todo: create token
            } else {
                throw new CreatePaymentTokenException("create customer token operation was timed out for customer id: " + customerId);
            }
        } catch (InterruptedException e) {
            throw new CreatePaymentTokenException("create customer token operation was interrupted for customer id: " + customerId);
        }


        return null;
    }
}
