package com.sunday;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<OrderableProduct, Integer> items;
    private final String number;
    private String notes;
    private OrderStatus status;

    public Order(String number) {
        this(null, number);
    }

    public Order(String notes, String number) {
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
        var totalAmount = 0;

        for (var entry : items.entrySet()) {
            totalAmount += entry.getKey().price() * entry.getValue();
        }

        return totalAmount;
    }

    public String number() {
        return notes;
    }

    public void confirm() {
        status = OrderStatus.CONFIRMED;
    }

    public void deliver() {
        status = OrderStatus.DELIVERED;
    }

    public void place() {
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
