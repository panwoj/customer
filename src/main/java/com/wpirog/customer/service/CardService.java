package com.wpirog.customer.service;

import com.wpirog.customer.provider.CardProvider;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {
    private static final String CIRCUIT_BREAKER_INSTANCE_NAME = "cardService";

    private final CardProvider cardsProvider;

    @CircuitBreaker(name = CIRCUIT_BREAKER_INSTANCE_NAME, fallbackMethod = "findCardFallback")
    public String findCustomerCardNumber(Long idCustomer) {
        return cardsProvider.getCardNumber(idCustomer);
    }

    private String findCardFallback(Long idCustomer, FeignException ex) {
        log.warn("Can not get card number for customerId {}", idCustomer);
        return "";
    }

    private String findCardFallback(Long idCustomer, CallNotPermittedException ex) {
        log.warn(ex.getMessage());
        return "";
    }
}
