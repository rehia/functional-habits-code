package com.sunday;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Product> products;

    public Menu(List<Product> products) {
        this.products = products;
    }

    public List<Product> productsWithDiscount(int discount) {
        List<Product> discountedProducts = new ArrayList<>();

        for (Product product : products) {
            product.applyDiscount(discount);
            discountedProducts.add(product);
        }

        return discountedProducts;
    }
}
