package com.sunday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private final OrderableProduct ouiche = new OrderableProduct("Ouiche lorraine", 1000);
    private final OrderableProduct biere = new OrderableProduct("Bière", 600);

    @Test
    void should_sum_all_items_to_get_total_amount() {
        var order = new Order(new OrderNumber("O-1234"));
        order.addProduct(ouiche, 1);
        order.addProduct(biere, 2);

        var totalAmount = order.totalAmount();

        assertEquals(2200, totalAmount);
    }
}