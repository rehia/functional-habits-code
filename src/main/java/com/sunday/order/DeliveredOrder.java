package com.sunday.order;

public final class DeliveredOrder implements Order {
    private final OrderContent content;

    public DeliveredOrder(OrderContent content) {
        this.content = content;
    }

    @Override
    public int totalAmount() {
        return content.totalAmount();
    }

    @Override
    public OrderNumber orderNumber() {
        return content.number();
    }
}
