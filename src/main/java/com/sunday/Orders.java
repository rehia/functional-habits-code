package com.sunday;

public interface Orders {
    void save(Order order);

    Order get(OrderNumber orderNumber);
}
