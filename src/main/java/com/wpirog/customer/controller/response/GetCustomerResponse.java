package com.wpirog.customer.controller.response;

import com.wpirog.customer.domain.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetCustomerResponse {
    private List<CustomerDto> customers;
}
