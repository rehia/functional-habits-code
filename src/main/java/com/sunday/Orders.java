package com.sunday;

import com.sunday.order.Order;
import com.sunday.order.OrderNumber;

public interface Orders {
    void save(Order order);

    Order get(OrderNumber orderNumber);
}
