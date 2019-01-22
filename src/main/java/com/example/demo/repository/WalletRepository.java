package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Long> {

}
