package com.example.az.app.service.api;

import com.example.az.app.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/orders") // api versioning via the uri
@CrossOrigin("*")
// not recommended! a better approach would be for the SPA to use a proxy or some sort of backend server/BFF e.g. express
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

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable UUID id) {
        Order order = orderService.get(id);
        return ResponseEntity.ok(order);
    }

    // If we use Spring Security we could lock these endpoints down to specific roles e.g. @Secured("Orders.Write")
    @PostMapping // We could use PUT and detect duplicates if we wanted to make this idempotent
    public ResponseEntity<Order> create(@RequestBody @Valid OrderDetails orderDetails) {
        Order order = orderService.create(orderDetails);
        return ResponseEntity
                .created(URI.create("/v1/orders/%s".formatted(order.id())))
                .body(order);
    }
}

// TODO: WebMvc slice tests might be useful here.
