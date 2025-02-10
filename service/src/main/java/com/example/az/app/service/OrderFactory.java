package com.example.az.app.service;

import com.example.az.app.service.api.Order;
import com.example.az.app.service.api.OrderDetails;

import java.util.Optional;

public final class OrderFactory {

    private OrderFactory() {
    }

    public static Order create(OrderEntity order) {
        var orderDetails = new OrderDetails(
                order.getTitle(),
                order.getFirstName(),
                order.getLastName(),
                Optional.ofNullable(order.getDateOfBirth())
        );
        return new Order(order.getId(), orderDetails);
    }
}
