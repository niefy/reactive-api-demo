package com.github.niefy.service;

import com.github.niefy.entity.Customer;
import reactor.core.publisher.Mono;

public interface CustomerService {
    public Mono<Customer> saveTransactional(Customer customer);

    public Mono<Customer> save(Customer customer);
}
