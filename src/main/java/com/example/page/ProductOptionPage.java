package com.example.page;

import com.example.response.ProductResponse;

public class ProductOptionPage implements Page {

    private final ProductResponse product;

    public ProductOptionPage(ProductResponse product) {
        this.product = product;
    }

    @Override
    public String render() {
        return null;
    }
}
