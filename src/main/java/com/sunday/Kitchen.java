package com.sunday;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kitchen {
    private Queue<Order> placedOrderQueue;
    private Queue<Order> inPreparationOrderQueue;

    public Kitchen() {
        this.placedOrderQueue = new LinkedList<>();
        this.inPreparationOrderQueue = new LinkedList<>();
    }

    public void receiveOrder(Order order) {
        order.place();
        placedOrderQueue.add(order);
    }

    public void prepareNextOrder() {
        var nextOrder = placedOrderQueue.poll();
        if (nextOrder != null) {
            nextOrder.confirm();
            inPreparationOrderQueue.add(nextOrder);
        }
    }

    public List<OrderNumber> ordersInPreparation() {
        return this.inPreparationOrderQueue.stream()
            .map(Order::orderNumber)
            .toList();
    }
}
