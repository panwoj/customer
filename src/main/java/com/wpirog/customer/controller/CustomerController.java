package com.wpirog.customer.controller;

import com.wpirog.customer.controller.response.GetCustomerResponse;
import com.wpirog.customer.domain.CustomerDto;
import com.wpirog.customer.mapper.CustomerMapper;
import com.wpirog.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idCustomer}")
    public GetCustomerResponse getCustomers(@PathVariable Long idCustomer) {
        List<CustomerDto> customers = List.of(mapper.mapToCustomerDto(customerService.getAccount(idCustomer)));

        return GetCustomerResponse.of(customers);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(mapper.mapToCustomer(customerDto));
    }
}