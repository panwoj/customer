package com.wpirog.customer.controller;

import com.wpirog.customer.controller.response.GetCustomerProductResponse;
import com.wpirog.customer.controller.response.GetCustomerResponse;
import com.wpirog.customer.domain.AccountDto;
import com.wpirog.customer.domain.CustomerDto;
import com.wpirog.customer.mapper.CustomerMapper;
import com.wpirog.customer.service.CustomerService;
import com.wpirog.customer.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private ProductService productService;

    @GetMapping("/{idCustomer}")
    public GetCustomerResponse getCustomers(@PathVariable Long idCustomer) {
        var customer = customerService.getCustomer(idCustomer).orElse(null);
        if (customer == null) {
            return GetCustomerResponse.of(Collections.emptyList());
        }
        return GetCustomerResponse.of(List.of(mapper.mapToCustomerDto(customer)));
    }

    @GetMapping("/{idCustomer}/products")
    public GetCustomerProductResponse getCustomerProducts(@PathVariable Long idCustomer) {
        CustomerDto customerDto = mapper.mapToCustomerDto(customerService.getCustomer(idCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)));
        AccountDto accountDto = productService.findCustomersAccount(idCustomer);

        log.info("Get products for customerId: {}", idCustomer);
        return GetCustomerProductResponse.builder()
                .customerId(customerDto.getId())
                .fullName(customerDto.getFirstName() + " " + customerDto.getLastName())
                .accounts(List.of(accountDto))
                .build();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(mapper.mapToCustomer(customerDto));
    }
}
