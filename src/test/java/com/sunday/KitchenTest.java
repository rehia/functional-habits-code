package com.sunday;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KitchenTest {
    OrderableProduct ipa = new OrderableProduct("IPA 25cl", 500);
    OrderableProduct belgianBeer = new OrderableProduct("Belgian Beer 33cl", 600);
    OrderableProduct chips = new OrderableProduct("Chips", 200);

    @Test
    @Disabled
    void should_list_order_in_preparation() {
        // Given
        var kitchen = new Kitchen();
        var order1 = new Order("O-1234", "On est assez pressés! Merci de faire vite!");
        order1.addProduct(ipa, 2);
        order1.addProduct(chips, 1);
        var order2 = new Order("O-1235");
        order2.addProduct(belgianBeer, 1);
        var order3 = new Order("O-1236", "Je crains la coriandre");
        order3.addProduct(ipa, 1);
        order3.addProduct(belgianBeer, 1);

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