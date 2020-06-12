package com.github.niefy.service.impl;

import com.github.niefy.entity.Customer;
import com.github.niefy.repository.CustomerRepository;
import com.github.niefy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    @Transactional
    public Mono<Customer> saveTransactional(Customer customer) {
        return repository.save(customer).map(it->{
            if(it.getFirstName().equals("Dave")) // mock test transation roolback
                throw new IllegalStateException();
            else
                return it;
        });
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer);
    }
}
