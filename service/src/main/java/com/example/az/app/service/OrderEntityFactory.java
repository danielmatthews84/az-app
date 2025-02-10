package com.example.az.app.service;

import com.example.az.app.service.api.OrderDetails;

public final class OrderEntityFactory {

    private OrderEntityFactory() {
    }

    public static OrderEntity create(OrderDetails orderDetails) {
        return new OrderEntity(
                orderDetails.title(),
                orderDetails.firstName(),
                orderDetails.lastName(),
                orderDetails.dateOfBirth().orElse(null)
        );
    }
}
