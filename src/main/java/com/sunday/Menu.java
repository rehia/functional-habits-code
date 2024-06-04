package com.sunday;

import java.util.List;

public class Menu {
    private final List<OrderableProduct> products;

    public Menu(List<OrderableProduct> products) {
        this.products = products;
    }

    public List<OrderableProduct> productsWithDiscount(int discount) {
        return ListUtils.map(products, product -> product.applyDiscount(discount));
    }

    public List<SubProduct> allSubProducts() {
        return ListUtils.flatMap(products, OrderableProduct::subProducts);
    }
}
