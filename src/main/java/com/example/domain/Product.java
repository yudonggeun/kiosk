package com.example.domain;

public class Product extends Menu {

    private int price;

    public Product(String name, String description, int price) {
        super(description, name);
        this.price = price;
    }

    public int price() {
        return price;
    }

    class Single {

    }

    class Double {

    }
}
