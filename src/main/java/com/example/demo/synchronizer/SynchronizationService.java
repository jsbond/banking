package com.example.demo.synchronizer;

import java.util.concurrent.locks.ReentrantLock;

public interface SynchronizationService<T> {
    ReentrantLock getLock(T t);
}
