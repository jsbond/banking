package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.facade.CustomerFacade;
import com.example.demo.service.CustomerService;

@RestController("/customer")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;


    @PostMapping("/{customerId}/token")
    public String createCustomerToken(@PathVariable(value = "customerId") Long customerId) {
        return customerFacade.createCustomerToken(customerId);
    }



}
