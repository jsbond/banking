package com.example.demo.service;

import com.example.demo.domain.Customer;
import com.example.demo.dto.CustomerDTO;

public interface CustomerService {
    Customer findById(Long id);
}
