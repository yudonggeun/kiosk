package com.example.page;

import com.example.domain.Product;

public class ProductPurchasePage implements Page{
    private final Product product;

    public ProductPurchasePage(Product product) {
        this.product = product;
    }

    @Override
    public String render() {
        return new StringBuilder()
                .append(String.format("\"%-10s | %10d원 | %s\"\n", product.name(), product.price(), product.description()))
                .append("위 메뉴를 장바구니에 추가하시겠습니까?\n")
                .append("1. 확인     2. 취소").toString();
    }
}
