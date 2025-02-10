package com.example.az.app.service;

import com.example.az.app.service.api.OrderDetails;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class OrderFixtures {

    private static final LocalDate DATE = LocalDate.of(1970, 1, 1);

    public static OrderDetails orderDetails() {
        return OrderDetails.builder()
                .title("title")
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(Optional.of(DATE))
                .build();
    }

    public static OrderEntity orderEntity() {
        return OrderEntity.builder()
                .id(UUID.randomUUID())
                .title("title")
                .firstName("firstName")
                .lastName("lastName")
                .dateOfBirth(DATE)
                .build();
    }
}
