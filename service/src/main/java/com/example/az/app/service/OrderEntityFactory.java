package com.example.az.app.service;

import com.example.az.app.service.api.OrderDetails;

public final class OrderEntityFactory {

    private OrderEntityFactory() {
    }

    public static OrderEntity create(OrderDetails orderDetails) {
        return OrderEntity.builder()
                .title(orderDetails.title())
                .firstName(orderDetails.firstName())
                .lastName(orderDetails.lastName())
                .dateOfBirth(orderDetails.dateOfBirth().orElse(null))
                .build();
    }
}
