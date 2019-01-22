package com.example.demo.service.impl;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.CustomerToCustomerDTOConverter;
import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Wallet;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.WalletRepository;
import com.example.demo.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerToCustomerDTOConverter toCustomerDTOConverter;

    @PostConstruct
    public void init() {
        Customer customer = new Customer();
        customer.setName("Jack");

        Wallet wallet = new Wallet();
        wallet.setCustomer(customer);
        wallet.setAmount(BigDecimal.valueOf(0));

        Account account = new Account();
        account.setAmount(BigDecimal.valueOf(50));
        account.setCustomer(customer);

        customerRepository.save(customer);
        walletRepository.save(wallet);
        accountRepository.save(account);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
