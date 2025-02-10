package com.example.az.app.service.api;

import com.example.az.app.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/orders") // version api (explain)
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<OrderList> list() {
        List<Order> orders = orderService.list();
        return ResponseEntity.ok(new OrderList(orders));
    }

    @GetMapping("/{id}") // restful uri structure (explain)
    public ResponseEntity<Order> get(@PathVariable UUID id) {
        Order order = orderService.get(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping // POST over PUT (not idempotent - explain)
    public ResponseEntity<Order> create(@RequestBody @Valid OrderDetails orderDetails) {
        Order order = orderService.create(orderDetails);
        return ResponseEntity
                .created(URI.create("/v1/orders/%s".formatted(order.id())))
                .body(order);
    }
}
