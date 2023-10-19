package com.example.domain;

import com.example.domain.product.Product;

public record Order(Product product, int count) {
}
