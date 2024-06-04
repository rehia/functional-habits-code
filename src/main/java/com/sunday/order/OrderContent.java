package com.sunday.order;

import com.sunday.ListUtils;
import com.sunday.OrderableProduct;

import java.util.Map;

public record OrderContent(
    OrderNumber number,
    Map<OrderableProduct, Integer> items,
    OrderNotes notes
) {
    Integer totalAmount() {
        return ListUtils.reduce(
            items().entrySet(),
            0,
            (total, entry) -> total + entry.getKey().price() * entry.getValue()
        );
    }

    void addProductToItems(OrderableProduct product, int quantity) {
        if (items().containsKey(product)) {
            items().put(product, items().get(product) + quantity);
            return;
        }
        items().put(product, quantity);
    }
}
