package com.sunday.order;

public sealed interface Order permits PendingOrder, PlacedOrder, ConfirmedOrder, DeliveredOrder {
    int totalAmount();
    OrderNumber orderNumber();
}
