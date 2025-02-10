package com.example.az.app.service.api;

import java.util.UUID;

public record Order(UUID id,
                    OrderDetails details) {
}
