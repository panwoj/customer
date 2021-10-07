package com.wpirog.customer.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
}
