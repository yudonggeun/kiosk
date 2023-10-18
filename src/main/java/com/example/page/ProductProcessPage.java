package com.example.page;

import com.example.response.ProductResponse;

public class ProductProcessPage implements Page{
    private final ProductResponse product;

    public ProductProcessPage(ProductResponse product) {
        this.product = product;
    }

    @Override
    public String render() {
        return new StringBuilder()
                .append(String.format("%-10s | %10d원 | %s\n", product.name(), product.price(), product.description()))
                .append("위 메뉴를 장바구니에 추가하시겠습니까?\n")
                .append("1. 확인     2. 취소").toString();
    }
}
