package com.sunday;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<OrderableProduct> products;

    public Menu(List<OrderableProduct> products) {
        this.products = products;
    }

    public List<OrderableProduct> productsWithDiscount(int discount) {
        List<OrderableProduct> discountedProducts = new ArrayList<>();

        for (OrderableProduct product : products) {
            product.applyDiscount(discount);
            discountedProducts.add(product);
        }

        return discountedProducts;
    }

    public List<SubProduct> allSubProducts() {
        List<SubProduct> allProducts = new ArrayList<>();

        for (OrderableProduct product : products) {
            allProducts.addAll(product.subProducts());
        }

        return allProducts;
    }
}
