package com.sunday;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuTest {
    private final SubProduct champignons = new SubProduct("Champignons", 1);
    private final SubProduct comte = new SubProduct("Comté", 1);
    private OrderableProduct ouiche = new OrderableProduct("Ouiche lorraine", 1000, List.of(comte, champignons));
    private OrderableProduct chips = new OrderableProduct("Chips", 400);
    private final SubProduct siropDePeche = new SubProduct("Sirop de pêche", 1);
    private OrderableProduct biere = new OrderableProduct("Bière", 600, List.of(siropDePeche));

    @Test
    void should_apply_a_discount_to_all_products() {
        // Given
        var menu = new Menu(List.of(ouiche, chips, biere));

        // When
        var discountedProducts = menu.productsWithDiscount(100);

        // Then
        assertEquals(900, discountedProducts.get(0).price());
        assertEquals(300, discountedProducts.get(1).price());
        assertEquals(500, discountedProducts.get(2).price());
    }

    @Test
    void should_get_all_products_of_menu() {
        // Given
        var menu = new Menu(List.of(ouiche, chips, biere));

        // When
        var allSubProducts = menu.allSubProducts();

        // Then
        assertEquals(3, allSubProducts.size());
        assertTrue(allSubProducts.contains(comte));
        assertTrue(allSubProducts.contains(champignons));
        assertTrue(allSubProducts.contains(siropDePeche));
    }

    @Test
    void should_not_change_products_price_in_menu_after_applying_discount() {
        // Given
        var menu = new Menu(List.of(ouiche, chips, biere));

        // When
        menu.productsWithDiscount(100);

        // Then
        assertEquals(1000, ouiche.price());
        assertEquals(400, chips.price());
        assertEquals(600, biere.price());
    }
}