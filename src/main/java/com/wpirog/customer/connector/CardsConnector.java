package com.wpirog.customer.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards")
public interface CardsConnector {
    @GetMapping("v1/cards")
    String getCardNumber(@RequestParam ("customerId") Long customerId);
}
