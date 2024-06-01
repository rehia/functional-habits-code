package com.sunday;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void applyDiscount(int discount) {
        this.price = this.price - discount;
    }

    public int price() {
        return price;
    }
}
