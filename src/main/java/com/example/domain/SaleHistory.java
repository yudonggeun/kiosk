package com.example.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleHistory {

    private final Map<Product, Integer> history = new HashMap<>();

    public SaleHistory sale(Order order){
        history.putIfAbsent(order.product(), 0);
        history.computeIfPresent(order.product(), (product, count) -> count + order.count());
        return this;
    }
    public List<Product> products() {
        return history.keySet().stream().toList();
    }
}
