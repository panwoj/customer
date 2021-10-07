package com.wpirog.customer.service;

import com.wpirog.customer.domain.Customer;
import com.wpirog.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getAccount(final Long idCustomer) {
        return repository.findById(idCustomer).get();
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }
}
