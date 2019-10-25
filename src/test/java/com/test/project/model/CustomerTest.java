package com.test.project.model;

import com.test.project.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerTest {

    @Autowired
    private CustomerRepository  customerRepository;



    @Test
    void checksIfExecptionIsThrownIfNameIsBlankOrNull() {

        Customer custom = new Customer();

        custom.setFirstName(null);

        assertThrows(org.springframework.transaction.TransactionSystemException.class, () -> customerRepository.save(custom));


    }
}