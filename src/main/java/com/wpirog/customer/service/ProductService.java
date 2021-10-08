package com.wpirog.customer.service;

import com.wpirog.customer.domain.AccountDto;
import com.wpirog.customer.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountsProvider accountsProvider;


    public AccountDto findCustomersAccount(Long idCustomer) {
        return accountsProvider.getCustomerAccounts(idCustomer);
    }
}
