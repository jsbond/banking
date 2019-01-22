package com.example.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Wallet;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.WalletDTO;

@Component
public class WalletToWalletDTOConverter implements Converter<Wallet, WalletDTO> {


    @Override
    public WalletDTO convert(Wallet wallet) {
        WalletDTO result = new WalletDTO();
        result.setId(wallet.getId());
        result.setAmount(wallet.getAmount());

        return result;
    }
}
