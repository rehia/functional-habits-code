package com.sunday;

import java.util.List;

public class OrderableProduct {
    private final String name;
    private int price;
    private final List<SubProduct> subProducts;

    public OrderableProduct(String name, int price, List<SubProduct> subProducts) {
        this.name = name;
        this.price = price;
        this.subProducts = subProducts;
    }

    public OrderableProduct(String name, int price) {
        this(name, price, List.of());
    }

    public void applyDiscount(int discount) {
        this.price = this.price - discount;
    }

    public int price() {
        return price;
    }

    public String name() {
        return name;
    }

    public List<SubProduct> subProducts() {
        return subProducts;
    }
}
