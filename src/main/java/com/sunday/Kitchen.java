package com.sunday;

import com.sunday.order.ConfirmedOrder;
import com.sunday.order.OrderNumber;
import com.sunday.order.PendingOrder;
import com.sunday.order.PlacedOrder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kitchen {
    private Queue<PlacedOrder> placedOrderQueue;
    private Queue<ConfirmedOrder> inPreparationOrderQueue;

    public Kitchen() {
        this.placedOrderQueue = new LinkedList<>();
        this.inPreparationOrderQueue = new LinkedList<>();
    }

    public void receiveOrder(PendingOrder order) {
        var placedOrder = order.place();
        placedOrderQueue.add(placedOrder);
    }

    public void prepareNextOrder() {
        var nextOrder = placedOrderQueue.poll();
        if (nextOrder != null) {
            var confirmedOrder = nextOrder.confirm();
            inPreparationOrderQueue.add(confirmedOrder);
        }
    }

    public List<OrderNumber> ordersInPreparation() {
        return this.inPreparationOrderQueue.stream()
            .map(ConfirmedOrder::orderNumber)
            .toList();
    }
}
