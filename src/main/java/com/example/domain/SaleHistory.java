package com.example.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleHistory {

    private final Map<Product, Integer> history = new HashMap<>();

    public void sale(Product product, int count) {
        history.putIfAbsent(product, 0);
        history.computeIfPresent(product, (p, c) -> c + count);
    }
    public List<Product> products() {
        return history.keySet().stream().toList();
    }

    public int totalSalePrice(){
        int totalSalePrice = 0;
        for (var entry : history.entrySet()) {
            var product = entry.getKey();
            var count = entry.getValue();
            totalSalePrice += product.price() * count;
        }
        return totalSalePrice;
    }
}
