package com.wpirog.customer.repository;

import com.wpirog.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    Optional<Customer> findById(Long id);

    @Override
    Customer save(Customer customer);
}
