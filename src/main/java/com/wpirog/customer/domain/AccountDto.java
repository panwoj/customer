package com.wpirog.customer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
}
