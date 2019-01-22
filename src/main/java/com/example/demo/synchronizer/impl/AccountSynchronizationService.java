package com.example.demo.synchronizer.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Component;

import com.example.demo.exception.CreatePaymentTokenException;
import com.example.demo.synchronizer.SynchronizationService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
public class AccountSynchronizationService implements SynchronizationService<Long> {
    private LoadingCache<Long, ReentrantLock> accountIdToAccountCache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .build(new CacheLoader<Long, ReentrantLock>() {
                @Override
                public ReentrantLock load(Long aLong) {
                    return new ReentrantLock();
                }
            });

    public ReentrantLock getLock(Long accountId) {
        try {
            return accountIdToAccountCache.get(accountId);
        } catch (ExecutionException e) {
            throw new CreatePaymentTokenException("can't create customer token for account id: " + accountId);
        }
    }
}
