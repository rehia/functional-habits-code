package com.sunday;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @Test
    void should_apply_a_discount_to_all_products() {
        // Given
        Product product1 = new Product("Ouiche lorraine", 1000);
        Product product2 = new Product("Chips", 400);
        Product product3 = new Product("Bière", 600);
        Menu menu = new Menu(List.of(product1, product2, product3));

        // When
        var discountedProducts = menu.productsWithDiscount(100);

        // Then
        assertEquals(900, discountedProducts.get(0).price());
        assertEquals(300, discountedProducts.get(1).price());
        assertEquals(500, discountedProducts.get(2).price());
    }
}