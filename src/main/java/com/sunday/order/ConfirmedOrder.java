package com.sunday.order;

public final class ConfirmedOrder implements Order {
    private final OrderContent content;

    public ConfirmedOrder(OrderContent content) {
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

    public DeliveredOrder deliver() {
        return new DeliveredOrder(content);
    }
}
