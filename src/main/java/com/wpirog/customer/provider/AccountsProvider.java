package com.wpirog.customer.provider;

import com.wpirog.customer.connector.AccountsConnector;
import com.wpirog.customer.domain.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsProvider {
    private final AccountsConnector connector;

    public AccountDto getCustomerAccounts(Long customerId) {
        return connector.getAccount(customerId);
    }
}
