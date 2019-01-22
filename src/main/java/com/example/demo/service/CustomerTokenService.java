package com.example.demo.service;

import java.util.Optional;

public interface CustomerTokenService {
    String findByCustomerId(Long customerId);
}
