package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
