package com.example.demo.facade;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public interface CustomerFacade {
    String createCustomerToken(Long customerId);
}
