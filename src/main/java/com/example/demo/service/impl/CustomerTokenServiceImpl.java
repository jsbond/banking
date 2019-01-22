package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.PaymentToken;
import com.example.demo.repository.CustomerTokenRepository;
import com.example.demo.service.CustomerTokenService;

@Service
public class CustomerTokenServiceImpl implements CustomerTokenService {
    @Autowired
    private CustomerTokenRepository customerTokenRepository;


    public String findByCustomerId(Long customerId) {
        return customerTokenRepository.findByCustomerId(customerId)
                .orElse(new PaymentToken())
                .getToken();
    }

}
