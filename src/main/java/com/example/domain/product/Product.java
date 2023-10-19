package com.example.domain.product;

public class Product {

    private String name;
    private String description;
    private int price;

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
