package com.example.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> products = new HashMap<>();
    private int totalPrice = 0;

    public int totalPrice() {
        return totalPrice;
    }

    public Map<Product, Integer> listMap() {
        return products;
    }

    public Cart addOrder(Order order) {
        var product = order.product();
        int count = order.count();

        products.putIfAbsent(product, 0);
        products.computeIfPresent(product, (p, c) -> c + count);
        totalPrice += product.price() * count;

        return this;
    }
}
