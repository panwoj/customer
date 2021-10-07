package com.wpirog.customer.mapper;

import com.wpirog.customer.domain.Customer;
import com.wpirog.customer.domain.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDto mapToCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }

    public Customer mapToCustomer(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }
        return Customer.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
    }
}
