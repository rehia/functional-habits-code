package com.sunday;

public record PlaceOrderCommand(String orderNumber) {
    public static class Handler {
        private final Orders orders;

        public Handler(Orders orders) {
            this.orders = orders;
        }

        public void handle(PlaceOrderCommand command) {
            var order = orders.get(command.orderNumber());
            order.place();
            orders.save(order);
        }
    }
}
