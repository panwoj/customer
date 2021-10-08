package com.wpirog.customer.connector;

import com.wpirog.customer.domain.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accounts")
public interface AccountsConnector {
    @GetMapping("v1/accounts")
    AccountDto getAccount(@RequestParam ("customerId") Long customerId);
}
