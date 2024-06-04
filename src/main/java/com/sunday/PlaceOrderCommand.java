package com.sunday;

import com.sunday.order.OrderNumber;
import com.sunday.order.PendingOrder;

public record PlaceOrderCommand(OrderNumber orderNumber) {
    public static class Handler {
        private final Orders orders;

        public Handler(Orders orders) {
            this.orders = orders;
        }

        public void handle(PlaceOrderCommand command) {
            var order = orders.get(command.orderNumber());
            var placedOrder = switch (order) {
                case PendingOrder pendingOrder -> pendingOrder.place();
                default -> throw new IllegalStateException("Order can only be placed if it is in PENDING status.");
            };
            orders.save(placedOrder);
        }
    }
}
