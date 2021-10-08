package com.wpirog.customer.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
}
