package com.wpirog.customer.service;

import com.wpirog.customer.domain.AccountDto;
import com.wpirog.customer.provider.AccountsProvider;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private static final String CIRCUIT_BREAKER_INSTANCE_NAME = "productService";

    private final AccountsProvider accountsProvider;

    @CircuitBreaker(name = CIRCUIT_BREAKER_INSTANCE_NAME, fallbackMethod = "findCustomersAccountfallback")
    public AccountDto findCustomersAccount(Long idCustomer) {
        return accountsProvider.getCustomerAccounts(idCustomer);
    }

    private AccountDto findCustomersAccountfallback(Long idCustomer, FeignException ex) {
        log.warn("Can not get accounts for customerId {}", idCustomer);
        return new AccountDto();
    }

    private AccountDto findCustomersAccountfallback(Long idCustomer, CallNotPermittedException ex) {
        log.warn(ex.getMessage());
        return new AccountDto();
    }
}
