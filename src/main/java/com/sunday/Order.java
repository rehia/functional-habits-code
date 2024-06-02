package com.sunday;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<OrderableProduct, Integer> items;

    public Order() {
        items = new HashMap<>();
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
}
