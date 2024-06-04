package com.sunday.order;

import com.sunday.OrderableProduct;

import java.util.HashMap;

public final class PendingOrder implements Order {
    private final OrderContent content;

    public PendingOrder(OrderNumber number) {
        this(number, null);
    }

    public PendingOrder(OrderNumber number, OrderNotes notes) {
        this.content = new OrderContent(number, new HashMap<>(), notes);
    }

    public void addProduct(OrderableProduct product, int quantity) {
        content.addProductToItems(product, quantity);
    }

    @Override
    public int totalAmount() {
        return content.totalAmount();
    }

    @Override
    public OrderNumber orderNumber() {
        return content.number();
    }

    public PlacedOrder place() {
        if (content.items().isEmpty()) {
            throw new IllegalStateException("Order must have at least one item to be placed.");
        }

        return new PlacedOrder(content);
    }
}
