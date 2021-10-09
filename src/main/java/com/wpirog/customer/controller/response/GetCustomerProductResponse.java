package com.wpirog.customer.controller.response;

import com.wpirog.customer.domain.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerProductResponse {
    private Long customerId;
    private String fullName;
    private List<AccountDto> accounts;
    private String cardNumber;
}
