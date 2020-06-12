package com.github.niefy.controller;

import com.github.niefy.entity.Customer;
import com.github.niefy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/info/{id}")
    private Mono<Customer> getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @GetMapping("/list")
    private Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/save")
    public Mono<Customer> save(@RequestBody Customer person) {
        return customerRepository.save(person);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> findById(@PathVariable Long id) {
        return customerRepository.deleteById(id);
    }
}
