package com.example.domain;

public class Product {

    private final String name;
    private final String description;
    private final int price;

    public Product(String name, String description, int price) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public int price() {
        return price;
    }

    public String description() {
        return description;
    }

    public String name() {
        return name;
    }
}
