package com.example.az.app.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    void createOrder() {
        var savedOrder = OrderFixtures.orderEntity();
        given(orderRepository.save(any(OrderEntity.class))).willReturn(savedOrder);

        var orderDetails = OrderFixtures.orderDetails();
        var order = orderService.create(orderDetails);

        assertThat(order.id()).isEqualTo(savedOrder.getId());
        assertThat(order.details()).isEqualTo(orderDetails);
    }
}