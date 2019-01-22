package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.PaymentToken;

public interface CustomerTokenRepository extends CrudRepository<PaymentToken, Long> {
    Optional<PaymentToken> findByCustomerId(Long customerId);
}
