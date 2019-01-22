package com.example.demo.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Customer;
import com.example.demo.dto.CustomerDTO;

@Component
public class CustomerToCustomerDTOConverter implements Converter<Customer, CustomerDTO> {
    @Autowired
    private WalletToWalletDTOConverter toWalletDTOConverter;

    @Override
    public CustomerDTO convert(Customer customer) {
        CustomerDTO result = new CustomerDTO();
        result.setId(customer.getId());
        result.setName(customer.getName());
        result.setWalletDTO(toWalletDTOConverter.convert(customer.getWallet()));

        return result;
    }
}
