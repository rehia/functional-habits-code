package com.sunday;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KitchenTest {
    @Test
    @Disabled
    void should_list_order_in_preparation() {
        // Given
        var kitchen = new Kitchen();
        var order1 = new Order("O-1234", "On est assez pressés! Merci de faire vite!");
        var order2 = new Order("O-1235");
        var order3 = new Order("O-1236", "Je crains la coriandre");
        kitchen.receiveOrder(order1);
        kitchen.receiveOrder(order2);
        kitchen.receiveOrder(order3);

        kitchen.prepareNextOrder();
        kitchen.prepareNextOrder();

        // When
        var ordersInPreparation = kitchen.ordersInPreparation();

        // Then
        assertEquals(List.of("O-1234", "O-1235"), ordersInPreparation);
    }
}