package com.wpirog.customer.service;

import com.wpirog.customer.domain.AccountDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com.wpirog:accounts:+:stubs:9000"
        }
)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void findCustomersAccount() {
        //Given
        Long customerId = 1L;

        //When
        AccountDto account = productService.findCustomersAccount(customerId);

        //Then
        assertNotNull(account);
        assertEquals(account.getId(), 95213);
        assertEquals(account.getNrb(), "08897810189710581776778244");
        assertEquals(account.getCurrency(), "PLN");
    }
}