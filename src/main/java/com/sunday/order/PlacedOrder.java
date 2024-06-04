package com.sunday.order;

public final class PlacedOrder implements Order {
    private final OrderContent content;

    public PlacedOrder(OrderContent content) {
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

    public ConfirmedOrder confirm() {
        return new ConfirmedOrder(content);
    }
}
