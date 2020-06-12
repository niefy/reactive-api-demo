package com.github.niefy.service.impl;

import com.github.niefy.entity.Customer;
import com.github.niefy.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

@SpringBootTest
@Slf4j
class CustomerServiceImplTest {
    @Autowired
    CustomerService customerService;

    @Test
    void testSave() throws InterruptedException {
        log.info("insert start");
        Mono<Customer> mono = customerService.save(new Customer("Bob","Zhou"));
        log.info("insert task submited");
//        Thread.sleep(1000);
        mono.subscribe(o->log.info("result：{}",o));
        log.info("end");
    }

    @Test
    void testRollback(){
        customerService.save(new Customer("Dave","Lee"));
    }

    @Test
    void testQuery(){

    }
}