package com.example.domain;

public class Order {
    private final Product product;
    private int count;

    public Order(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public int count() {
        return count;
    }

    public Product product(){
        return product;
    }
}
