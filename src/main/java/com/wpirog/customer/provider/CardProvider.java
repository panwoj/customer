package com.wpirog.customer.provider;

import com.wpirog.customer.connector.CardsConnector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardProvider {
    private final CardsConnector connector;

    public String getCardNumber(Long customerId) {
        return connector.getCardNumber(customerId);
    }
}
