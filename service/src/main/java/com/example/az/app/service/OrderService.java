package com.example.az.app.service;

import com.example.az.app.service.api.Order;
import com.example.az.app.service.api.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order get(UUID id) {
        var order = orderRepository.getReferenceById(id);
        return OrderFactory.create(order);
    }

    public Order create(OrderDetails orderDetails) {
        var order = OrderEntityFactory.create(orderDetails);
        return OrderFactory.create(orderRepository.save(order));
    }

    public List<Order> list() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderFactory::create)
                .toList();
    }
}
