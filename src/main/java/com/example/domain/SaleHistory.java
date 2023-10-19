package com.example.domain;

import com.example.domain.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleHistory {

    private final Map<Product, Integer> history = new HashMap<>();

    public SaleHistory sale(Product product, int count) {
        history.putIfAbsent(product, 0);
        history.computeIfPresent(product, (p, c) -> c + count);
        return this;
    }

    public List<Product> products() {
        return history.keySet().stream().toList();
    }
}
