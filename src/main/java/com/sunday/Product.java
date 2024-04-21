package com.sunday;

public class Product {
    private String name;
    private boolean isAvailable;
    private int price;

    public Product(String name, boolean isAvailable, int price) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void applyDiscount(int discount) {
        this.price = this.price - discount;
    }

    public int price() {
        return price;
    }
}
