package com.sunday;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<OrderableProduct, Integer> items;
    private final OrderNumber number;
    private OrderNotes notes;
    private OrderStatus status;

    public Order(OrderNumber number) {
        this(number, null);
    }

    public Order(OrderNumber number, OrderNotes notes) {
        this.number = number;
        this.notes = notes;
        this.items = new HashMap<>();
        this.status = OrderStatus.PENDING;
    }

    public void addProduct(OrderableProduct product, int quantity) {
        if (items.containsKey(product)) {
            items.put(product, items.get(product) + quantity);
            return;
        }
        items.put(product, quantity);
    }

    public int totalAmount() {
        return ListUtils.reduce(
            items.entrySet(),
            0,
            (total, entry) -> total + entry.getKey().price() * entry.getValue()
        );
    }

    public OrderNumber orderNumber() {
        return number;
    }

    public OrderStatus status() {
        return status;
    }

    public void confirm() {
        status = OrderStatus.CONFIRMED;
    }

    public void deliver() {
        status = OrderStatus.DELIVERED;
    }

    public void place() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Order can only be placed if it is in PENDING status.");
        }

        if (items.isEmpty()) {
            throw new IllegalStateException("Order must have at least one item to be placed.");
        }
        status = OrderStatus.PLACED;
    }

    public enum OrderStatus {
        PENDING,
        PLACED,
        CONFIRMED,
        DELIVERED,
        CANCELLED
    }
}
