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

    public Cart addProduct(Product product , int count) {
        if (count < 0) throw new IllegalArgumentException("상품 구매는 개수는 0보다 큽니다.");
        products.putIfAbsent(product, 0);
        products.computeIfPresent(product, (p, c) -> c + count);
        totalPrice += product.price() * count;
        return this;
    }
}
