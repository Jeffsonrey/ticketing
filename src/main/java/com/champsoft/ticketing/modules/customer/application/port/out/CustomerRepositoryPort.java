package com.champsoft.ticketing.modules.customer.application.port.out;

import com.champsoft.ticketing.modules.customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    Optional<Customer> findByEmailAddress(String emailAddress);

    Customer save(Customer customer);

    void delete(Customer customer);
}