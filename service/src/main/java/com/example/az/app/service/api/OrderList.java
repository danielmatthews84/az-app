package com.example.az.app.service.api;

import java.util.List;

// makes use of a root key "orders" allowing the payload to be extended without breaking compatability. e.g. pagination data etc...
public record OrderList(List<Order> orders) {
}
